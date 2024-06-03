package com.mini.asaas.payment

import com.mini.asaas.customer.Customer
import com.mini.asaas.payer.Payer
import com.mini.asaas.utils.enums.PaymentStatus

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@GrailsCompileStatic
@Transactional
class PaymentService {

    public Payment save(PaymentAdapter adapter) {
        Payment payment = new Payment()

        paymentBuildProperties(payment, adapter)

        payment.save(failOnError: true)

        return payment
    }

    public void processOverduePayments() {
        List<Long> overduePaymentsIds = Payment.outstandingOverduePayments().list().collect { it.id }


        if (overduePaymentsIds.isEmpty()) {
            log.info("Não foram encontradas cobranças vencidas")
            return
        }

        overduePaymentsIds.each { paymentId ->
            try {
                Payment.withNewTransaction { status ->
                    Payment payment = Payment.get(paymentId)
                    if (payment) {
                        payment.status = PaymentStatus.OVERDUE
                        payment.save(failOnError: true)
                    } else {
                        log.error("Pagamento de ID $paymentId não encontrado")
                    }
                }
            } catch (Exception exception) {
                log.error("Erro ao atualizar o status do pagamento $paymentId: ${exception.message}")
            }
        }
    }

    public void updateStatus(Long paymentId, PaymentStatus status) {
        Payment payment = Payment.get(paymentId)
        if (payment) {
            payment.status = status
            payment.save(flush: true)
        } else {
            log.error("Pagamento de ID $paymentId não encontrado")
        }
    }

    private static paymentBuildProperties(Payment payment, PaymentAdapter adapter) {
        payment.customer = Customer.read(adapter.customerId)
        payment.payer = Payer.read(adapter.payerId)
        payment.billingType = adapter.billingType
        payment.value = adapter.value
        payment.status = adapter.status
        payment.dueDate = adapter.dueDate
    }
}
