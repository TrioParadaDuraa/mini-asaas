package com.mini.asaas.notification

import com.mini.asaas.payment.Payment

import com.mini.asaas.utils.enums.PaymentStatus

import grails.events.annotation.Subscriber
import grails.gorm.transactions.Transactional

@Transactional
class NotificationService {

    @Subscriber
    void save(Payment payment) {
        Notification notification = new Notification()

        notification.customer = payment.customer
        notification.payment = payment
        notification.title = "Cobrança criada"
        notification.description = "Uma nova cobrança foi criada."

        notification.save(failOnError: true)
    }

    @Subscriber
    void delete(Payment payment) {
        payment.attach()

        Notification notification = new Notification()

        notification.customer = payment.customer
        notification.payment = payment
        notification.title = "Cobrança excluída"
        notification.description = "Uma cobrança foi excluída."

        notification.save(failOnError: true)
    }

    @Subscriber
    void updateStatus(Payment payment) {
        payment.attach()

        if (payment.status == PaymentStatus.OVERDUE) {
            Notification notification = new Notification()

            notification.customer = payment.customer
            notification.payment = payment
            notification.title = "Cobrança vencida"
            notification.description = "Uma cobrança passou da data de vencimento."

            notification.save(failOnError: true)
        } else if (payment.status in [PaymentStatus.RECEIVED, PaymentStatus.RECEIVED_IN_CASH]) {
            Notification notification = new Notification()

            notification.customer = payment.customer
            notification.payment = payment
            notification.title = "Pagamento recebido"
            notification.description = "O pagamento de uma cobrança foi recebido."

            notification.save(failOnError: true)
        }        
    }

    public List<Notification> list(Long customerId) {
        return Notification.query(["customerId": customerId]).list() as List<Notification>
    }
}
