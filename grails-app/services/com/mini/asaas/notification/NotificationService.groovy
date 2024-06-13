package com.mini.asaas.notification

import com.mini.asaas.payment.Payment

import grails.gorm.transactions.Transactional

@Transactional
class NotificationService {

    public void notify(Payment payment, String title, String description) {
        Notification notification = new Notification()

        notification.customer = payment.customer
        notification.payment = payment
        notification.title = title
        notification.description = description

        notification.save(failOnError: true)
    }

    public List<Notification> list(Long customerId) {
        return Notification.query(["customerId": customerId]).list() as List<Notification>
    }
}
