package com.mini.asaas.payment

import com.mini.asaas.customer.Customer
import com.mini.asaas.payer.Payer

import com.mini.asaas.utils.enums.PaymentStatus

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException

import org.apache.commons.lang.time.DateUtils

@GrailsCompileStatic
@Transactional
class PaymentService {

    public Payment save(PaymentAdapter adapter, Long customerId) {
        Payment payment = validate(adapter)

        if (payment.hasErrors()) throw new ValidationException("Erro ao criar cobrança", payment.errors)

        paymentBuildProperties(payment, adapter)
        payment.customer = Customer.read(customerId)

        payment.save(failOnError: true)

        return payment
    }

    public Payment find(Long paymentId, Long customerId) {
        Payment payment = Payment.query([customerId: customerId, id: paymentId]).get() as Payment

        if (!payment) {
            throw new Exception("Cobrança não encontrada")
        }

        return payment
    }

    public void update(Long paymentId, PaymentAdapter adapter) {
        Payment payment = Payment.get(paymentId)

        paymentBuildProperties(payment, adapter)

        payment.save(failOnError: true)
    }

    public void delete(Long paymentId) {
        Payment payment = Payment.get(paymentId)

        payment.deleted = true

        payment.save(failOnError: true)
    }

    public void restore(Long paymentId) {
        Payment payment = Payment.get(paymentId)
        
        payment.deleted = false

        payment.save(failOnError: true)
    }

    private void paymentBuildProperties(Payment payment, PaymentAdapter adapter) {
        payment.payer = Payer.read(adapter.payerId)
        payment.billingType = adapter.billingType
        payment.value = adapter.value
        payment.status = adapter.status
        payment.dueDate = adapter.dueDate
    }

    private Payment validate(PaymentAdapter adapter) {
        Payment payment = new Payment()
        
        if (adapter.value <= 0) {
            payment.errors.reject("value", null, "Valor inválido")
        }

        Date currentDate = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH)

        if (adapter.dueDate.getTime() - currentDate.getTime() < 0) {
            payment.errors.reject("dueDate", null, "Data de vencimento inválida")
        }

        return payment
    }

    private static Payment findPayment(Long paymentId) {
        Payment payment = Payment.get(paymentId)

        if (!payment) throw new RuntimeException("Pagamento de ID $paymentId não encontrado")

        return payment
    }

    public void processOverduePayments() {
        List<Long> overduePaymentsIds = Payment.overdueIds().list() as List<Long>

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
}
