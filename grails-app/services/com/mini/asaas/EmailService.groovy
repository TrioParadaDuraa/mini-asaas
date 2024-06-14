package com.mini.asaas

import grails.gorm.transactions.Transactional
import grails.plugins.mail.MailService

@Transactional
class EmailService {

    MailService MailService

    public void sendEmail(String toAddress, String emailSubject, String template) {
        mailService.sendMail {
            to(toAddress)
            subject(emailSubject)
            html(view: "/email/$template")
        }
    }
}
