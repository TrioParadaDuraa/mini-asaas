package com.mini.asaas

import com.mini.asaas.payment.Payment

import com.mini.asaas.utils.enums.PaymentStatus

import grails.events.annotation.Subscriber
import grails.gorm.transactions.Transactional
import grails.plugins.mail.MailService

@Transactional
class EmailService {

    MailService MailService

    @Subscriber
    void save(Payment payment) {
        String mailSubject = "Cobrança criada"

        mailService.sendMail {
            to(payment.payer.email)
            subject(mailSubject)
            html(view: "/email/payer/createdTemplate")
        }

        mailService.sendMail {
            to(payment.customer.email)
            subject(mailSubject)
            html(view: "/email/customer/createdTemplate")
        }
    }

    @Subscriber
    void delete(Payment payment) {
        payment.attach()

        String mailSubject = "Cobrança removida"

        mailService.sendMail {
            to(payment.payer.email)
            subject(mailSubject)
            html(view: "/email/payer/deletedTemplate")
        }

        mailService.sendMail {
            to(payment.customer.email)
            subject(mailSubject)
            html(view: "/email/customer/deletedTemplate")
        }
    }

    @Subscriber
    void updateStatus(Payment payment) {
        payment.attach()

        if (payment.status == PaymentStatus.OVERDUE) {
            String mailSubject = "Cobrança vencida"

            mailService.sendMail {
                to(payment.payer.email)
                subject(mailSubject)
                html(view: "/email/payer/overdueTemplate")
            }

            mailService.sendMail {
                to(payment.customer.email)
                subject(mailSubject)
                html(view: "/email/customer/overdueTemplate")
            }
        } else if (payment.status == PaymentStatus.RECEIVED || payment.status == PaymentStatus.RECEIVED_IN_CASH) {
            String mailSubject = "Pagamento recebido"

            mailService.sendMail {
                to(payment.payer.email)
                subject(mailSubject)
                html(view: "/email/payer/receivedTemplate")
            }

            mailService.sendMail {
                to(payment.customer.email)
                subject(mailSubject)
                html(view: "/email/customer/receivedTemplate")
            }
        }
    }
}
