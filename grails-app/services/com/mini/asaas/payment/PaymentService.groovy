package com.mini.asaas.payment

import com.mini.asaas.customer.Customer
import com.mini.asaas.payer.Payer

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException

import org.apache.commons.lang.time.DateUtils

@GrailsCompileStatic
@Transactional
class PaymentService {

    public Payment save(PaymentAdapter adapter, Long customerId) {
        Payment payment = validate(adapter)

        if (payment.hasErrors()) {
            throw new ValidationException("Erro ao criar cobrança", payment.errors)
        }

        paymentBuildProperties(payment, adapter)
        payment.customer = Customer.read(customerId)

        payment.save(failOnError: true)

        return payment
    }

    public update(Payment payment, PaymentAdapter adapter) {
        paymentBuildProperties(payment, adapter)

        payment.save(failOnError: true)
    }

    public delete(Payment payment) {
        payment.deleted = true

        payment.save(failOnError: true)
    }

    public restore(Payment payment) {
        payment.deleted = false

        payment.save(failOnError: true)
    }

    private paymentBuildProperties(Payment payment, PaymentAdapter adapter) {
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
}
