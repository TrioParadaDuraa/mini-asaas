package com.mini.asaas

import com.mini.asaas.payment.Payment

import grails.events.annotation.Subscriber
import grails.gorm.transactions.Transactional
import grails.plugins.mail.MailService

@Transactional
class EmailService {

    MailService MailService

    @Subscriber
    void save(Payment payment) {
        mailService.sendMail {
            to(payment.payer.email)
            subject("Cobrança criada")
            html(view: "/emailTemplates/payment/created", model: [payment: payment])
        }
    }

    @Subscriber
    void delete(Payment payment) {
        mailService.sendMail {
            to(payment.payer.email)
            subject("Cobrança removida")
            html(view: "/emailTemplates/payment/deleted", model: [payment: payment])
        }
    }

    
}
