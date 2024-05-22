package com.mini.asaas.payment

import grails.gorm.transactions.Transactional

@Transactional
class PaymentService {

    public Payment save() {
        Payment payment = new Payment()

        return payment
    }

    private Payment paymentBuildProperties(Payment payment, PaymentAdapter adapter) {


        return payment
    }
}
