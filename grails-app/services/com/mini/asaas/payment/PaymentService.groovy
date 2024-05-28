package com.mini.asaas.payment

import com.mini.asaas.customer.Customer
import com.mini.asaas.payer.Payer

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

    private paymentBuildProperties(Payment payment, PaymentAdapter adapter) {
        payment.customer = Customer.read(adapter.customerId)
        payment.payer = Payer.read(adapter.payerId)
        payment.billingType = adapter.billingType
        payment.value = adapter.value
        payment.status = adapter.status
        payment.dueDate = adapter.dueDate
    }
}
