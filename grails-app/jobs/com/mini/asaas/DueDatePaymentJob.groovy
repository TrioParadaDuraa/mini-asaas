package com.mini.asaas

import com.mini.asaas.payment.PaymentService

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@GrailsCompileStatic
class DueDatePaymentJob {

    static triggers = {
        cron name: 'dueDatePaymentJob', cronExpression: '0 0 0 * *?'
    }

    PaymentService paymentService

    @Transactional
    def execute() {
        try {
            paymentService.processOverduePayments()
        } catch (Exception exception) {
            log.error("Erro ao processar as cobranças vencidas: ${exception.message}")
        }
    }
}