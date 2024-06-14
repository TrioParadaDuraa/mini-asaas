package com.mini.asaas.payment

import com.mini.asaas.customer.Customer
import com.mini.asaas.notification.NotificationService
import com.mini.asaas.payer.Payer
import com.mini.asaas.utils.enums.PaymentStatus

import grails.compiler.GrailsCompileStatic
import grails.events.annotation.Publisher
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException

import org.apache.commons.lang.time.DateUtils

@GrailsCompileStatic
@Transactional
class PaymentService {

    NotificationService notificationService

    public Payment save(PaymentAdapter adapter, Long customerId) {
        Payment payment = validate(adapter)

        if (payment.hasErrors()) throw new ValidationException("Erro ao criar cobrança", payment.errors)

        paymentBuildProperties(payment, adapter)
        payment.customer = Customer.read(customerId)

        payment.save(failOnError: true)

        notificationService.notify(payment, "Cobrança criada", "Uma nova cobrança foi criada.")

        return payment
    }

    public Payment find(Map filterList) {
        Payment payment = Payment.query(filterList).get() as Payment

        if (!payment) throw new Exception("Cobrança não encontrada")

        return payment
    }

    public List<Payment> list(Map filterList) {
        if (!filterList.containsKey("deleted")) {
            filterList.deleted = false
        }

        return Payment.query(filterList).list() as List<Payment>
    }

    public void delete(Long paymentId, Long customerId) {
        Payment payment = find([id: paymentId, customerId: customerId])

        if (payment.deleted) throw new Exception("Cobrança já inativa")

        payment.deleted = true

        payment.save(failOnError: true)

        notificationService.notify(payment, "Cobrança excluída", "Uma cobrança foi excluída.")
    }

    public void restore(Long paymentId, Long customerId) {
        Payment payment = find([id: paymentId, customerId: customerId])

        if (!payment.deleted) throw new Exception("Cobrança não inativa")
        
        payment.deleted = false

        payment.save(failOnError: true)
    }

    private void paymentBuildProperties(Payment payment, PaymentAdapter adapter) {
        payment.payer = Payer.read(adapter.payerId)
        payment.billingType = adapter.billingType
        payment.value = adapter.value
        payment.status = adapter.status
        payment.dueDate = adapter.dueDate
    }

    private Payment validate(PaymentAdapter adapter) {
        Payment payment = new Payment()
        
        if (adapter.value <= 0) {
            payment.errors.reject("value", null, "Valor inválido")
        }

        Date currentDate = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH)

        if (adapter.dueDate.getTime() - currentDate.getTime() < 0) {
            payment.errors.reject("dueDate", null, "Data de vencimento inválida")
        }

        return payment
    }

    public void processOverduePayments() {
        List<Long> overduePaymentsIds = Payment.overdueIds().list() as List<Long>

        if (overduePaymentsIds.isEmpty()) return

        overduePaymentsIds.each { paymentId ->
            try {
                Payment.withNewTransaction {
                    updateStatus(paymentId, PaymentStatus.OVERDUE)
                }
            } catch (Exception exception) {
                log.error("Erro ao atualizar o status do pagamento $paymentId: ${exception.message}")
            }
        }
    }

    public void updateStatus(Long paymentId, PaymentStatus status) {
        Payment payment = find([id: paymentId])

        if (payment.deleted && status != PaymentStatus.OVERDUE) throw new Exception("Cobrança inativa")

        if ([PaymentStatus.RECEIVED, PaymentStatus.RECEIVED_IN_CASH].contains(status)) {
            if (payment.status != PaymentStatus.AWAITING_PAYMENT) {
                throw new Exception("Cobranças com status $payment.status não podem ser recebidas")
            }

            notificationService.notify(payment, "Pagamento recebido", "O pagamento de uma cobrança foi recebido.")
        }

        if (status == PaymentStatus.OVERDUE) {
            notificationService.notify(payment, "Cobrança vencida", "Uma cobrança passou da data de vencimento.")
        }

        payment.status = status

        payment.save(failOnError: true)
    }
}
