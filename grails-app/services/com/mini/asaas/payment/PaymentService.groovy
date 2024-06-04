package com.mini.asaas.payment

import com.mini.asaas.customer.Customer
import com.mini.asaas.payer.Payer

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@GrailsCompileStatic
@Transactional
class PaymentService {

    public Payment save(PaymentAdapter adapter, Long customerId) {
        Payment payment = new Payment()

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
}
