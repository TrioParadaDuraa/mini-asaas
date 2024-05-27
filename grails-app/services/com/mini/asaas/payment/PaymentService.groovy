package com.mini.asaas.payment

import com.mini.asaas.customer.Customer
import com.mini.asaas.payer.Payer

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@GrailsCompileStatic
@Transactional
class PaymentService {

    public Payment save(PaymentAdapter adapter, Long payerId, Long customerId) {
        Payment payment = new Payment()

        paymentBuildProperties(payment, adapter, payerId, customerId)

        payment.save(failOnError: true)

        return payment
    }

    private paymentBuildProperties(Payment payment, PaymentAdapter adapter, Long payerId, Long customerId) {
        payment.customer = Customer.read(customerId)
        payment.payer = Payer.read(payerId)
        payment.paymentType = adapter.paymentType
        payment.value = adapter.value
        payment.status = adapter.status
        payment.dueDate = adapter.dueDate
    }
}
