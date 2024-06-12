package com.mini.asaas.dashboard

import com.mini.asaas.BaseController
import com.mini.asaas.payer.Payer
import com.mini.asaas.payer.PayerService
import com.mini.asaas.payment.Payment
import com.mini.asaas.payment.PaymentService

import com.mini.asaas.utils.enums.PaymentStatus

import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.annotation.Secured

@GrailsCompileStatic
@Secured("isAuthenticated()")
class DashboardController extends BaseController{

    PaymentService paymentService

    PayerService payerService

    def index() {
        List <Payer> payerList = payerService.list([customerId: getCurrentCustomerId()]) as List <Payer>

        List <Payment> paymentList = paymentService.list([customerId: getCurrentCustomerId()]) as List <Payment>

        List <Payment> overduePayments = Payment.overdueIds([customerId: getCurrentCustomerId()]).list() as List <Payment>

        List <Payment> paymentsReceived = Payment.receivedPayments([customerId: getCurrentCustomerId()]).list() as List <Payment>

        def valuesToReceive = paymentList.sum {it.value ?: 0}

        def valuesReceived = paymentsReceived.sum {it.value ?: 0}

        return [payerList: payerList, paymentList: paymentList, overduePayments: overduePayments, paymentsReceived: paymentsReceived, valuesToReceive: valuesToReceive, valuesReceived: valuesReceived]
    }
}
