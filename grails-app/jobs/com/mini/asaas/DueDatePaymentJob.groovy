package com.mini.asaas

import com.mini.asaas.payment.Payment
import com.mini.asaas.utils.enums.PaymentStatus
import grails.compiler.GrailsCompileStatic
import org.springframework.transaction.annotation.Transactional

@GrailsCompileStatic
class DueDatePaymentJob {
    static triggers = {
        cron name: 'dueDatePaymentJob', cronExpression: '0 0 0 * *?'
    }

    @Transactional
    def execute() {
        List<Payment> overduePayments = Payment.findAllByDueDateLessThanOrEqualTo(new Date())

        if (overduePayments.isEmpty()) {
            log.info("Não foram encontradas cobranças vencidas")
            return
        }

        overduePayments.each { payment ->
            try {
                payment.status = PaymentStatus.OVERDUE
                payment.save(flush: true)
            } catch (Exception exception) {
                log.error("Erro ao atualizar o status do pagamento ${payment.id}: ${exception.message}")
            }
        }
    }
}