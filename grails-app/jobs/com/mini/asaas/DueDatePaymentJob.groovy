package com.mini.asaas

import com.mini.asaas.payment.PaymentService

import grails.gorm.transactions.Transactional

class DueDatePaymentJob {

    static triggers = {

    }

    PaymentService paymentService

    def execute() {
        try {
            paymentService.processOverduePayments()
        } catch (Exception exception) {
            log.error("Erro ao processar as cobranças vencidas: ${exception.message}")
        }
    }
}
