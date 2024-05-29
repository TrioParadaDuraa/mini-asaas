package com.mini.asaas

import com.mini.asaas.payment.Payment
import com.mini.asaas.utils.enums.PaymentStatus

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@GrailsCompileStatic
class DueDatePaymentJob {

    static triggers = {
        cron name: 'dueDatePaymentJob', cronExpression: '0 0 0 * *?'
    }

    @Transactional
    def execute() {
        Date currentDate = new Date()
        List<Long> overduePaymentsIds = Payment.findAllByDueDateLessThan(currentDate).findAll { payment ->
            !(payment.status in [PaymentStatus.RECEIVED, PaymentStatus.RECEIVED_IN_CASH])
        }*.id

        if (overduePaymentsIds.isEmpty()) {
            log.info("Não foram encontradas cobranças vencidas")
            return
        }

        overduePaymentsIds.each { paymentId ->
            Payment.withNewTransaction { ->
                try {
                    Payment payment = Payment.get(paymentId)
                    if (payment) {
                        payment.status = PaymentStatus.OVERDUE
                        payment.save(flush: true)
                    } else {
                        log.error("Payment with ID $paymentId not found")
                    }
                } catch (Exception exception) {
                    log.error("Erro ao atualizar o status do pagamento $paymentId: ${exception.message}")
                }
            }
        }
    }
}