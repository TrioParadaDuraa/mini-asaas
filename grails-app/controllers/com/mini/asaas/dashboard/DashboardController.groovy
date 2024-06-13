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
class DashboardController extends BaseController {

    PaymentService paymentService

    PayerService payerService

    def index() {
        List<Payer> payerList = payerService.list([customerId: getCurrentCustomerId(), deleted: false]) as List<Payer>

        List<Payment> paymentList = paymentService.list([customerId: getCurrentCustomerId(), deleted: false]) as List<Payment>

        List<Payment> openPayments = paymentList.findAll {it.status == PaymentStatus.AWAITING_PAYMENT} as List<Payment>

        List<Payment> paymentsReceived = paymentList.findAll {it.status == PaymentStatus.RECEIVED || it.status == PaymentStatus.RECEIVED_IN_CASH} as List<Payment>

        List<Payment> overduePayments = Payment.overdueIds([customerId: getCurrentCustomerId(), deleted: false]).list() as List<Payment>

        def valuesToReceive = openPayments.sum {it.value ?: 0 }

        def valuesReceived = paymentsReceived.sum {it.value ?: 0}

        return [payerList: payerList, openPayments: openPayments, overduePayments: overduePayments, paymentsReceived: paymentsReceived, valuesToReceive: valuesToReceive, valuesReceived: valuesReceived]
    }
}
