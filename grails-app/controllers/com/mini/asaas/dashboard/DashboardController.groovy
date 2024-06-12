package com.mini.asaas.dashboard

import com.mini.asaas.payer.Payer
import com.mini.asaas.payment.Payment

import com.mini.asaas.utils.enums.PaymentStatus

import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.annotation.Secured

@GrailsCompileStatic
class DashboardController {

    @Secured("isAuthenticated()")
    def index() {
        List <Payer> payerList = Payer.list()

        List <Payment> paymentList = Payment.list()

        List <Payment> overduePayments = paymentList.findAll {it.status == PaymentStatus.OVERDUE}

        List <Payment> receivedPayments = paymentList.findAll {it.status == PaymentStatus.RECEIVED || it.status == PaymentStatus.RECEIVED_IN_CASH}

        def valuesToReceive = paymentList.sum {it.value ?: 0}

        def valuesReceived = receivedPayments.sum {it.value ?: 0}

        return [payerList: payerList, paymentList: paymentList, overduePayments: overduePayments, receivedPayments: receivedPayments, valuesToReceive: valuesToReceive, valuesReceived: valuesReceived]
    }
}
