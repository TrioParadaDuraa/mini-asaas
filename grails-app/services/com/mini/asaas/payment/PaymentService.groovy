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

    private static Payment findPayment(Long paymentId) {
        Payment payment = Payment.get(paymentId)
        if (!payment) {
            throw new RuntimeException("Pagamento de ID $paymentId não encontrado")
        }
        return payment
    }

    public void processOverduePayments() {
        List<Long> overduePaymentsIds = Payment.overdueIds()

        if (overduePaymentsIds.isEmpty()) return

        overduePaymentsIds.each { paymentId ->
            try {
                Payment.withNewTransaction { status ->
                    Payment payment = findPayment(paymentId)
                    payment.status = PaymentStatus.OVERDUE
                    payment.save(failOnError: true)
                }
            } catch (Exception exception) {
                log.error("Erro ao atualizar o status do pagamento $paymentId: ${exception.message}")
            }
        }
    }

    public void updateStatus(Long paymentId, PaymentStatus status) {
        Payment payment = findPayment(paymentId)
        payment.status = status
        payment.save()
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
