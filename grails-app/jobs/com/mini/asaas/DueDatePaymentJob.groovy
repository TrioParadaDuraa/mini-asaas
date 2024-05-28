package com.mini.asaas.jobs

import com.mini.asaas.payment.Payment
import com.mini.asaas.utils.enums.PaymentStatus
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class DueDatePaymentJob {
    static triggers = {
        cron name: 'dueDatePaymentJob', cronExpression: '0 0 0 * *?'
    }

    def execute() {
        List<Payment> overduePayments = Payment.findAllByDueDateLessThanOrEqualTo(new Date())

        overduePayments.each { payment ->
            payment.status = PaymentStatus.OVERDUE
            payment.save(flush: true)
    }
}