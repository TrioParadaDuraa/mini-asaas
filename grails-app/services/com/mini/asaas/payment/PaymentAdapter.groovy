package com.mini.asaas.payment

import com.mini.asaas.utils.FormatUtils
import com.mini.asaas.utils.Utils
import com.mini.asaas.utils.enums.PaymentStatus
import com.mini.asaas.utils.enums.BillingType

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class PaymentAdapter {

    Long customerId

    Long payerId

    BillingType billingType

    BigDecimal value

    PaymentStatus status

    Date dueDate

    public PaymentAdapter(Map params) {
        this.customerId = 1
        this.payerId = 1
        this.billingType = BillingType.convert(params.paymentType.toString().toUpperCase())
        this.value = Utils.toBigDecimal(params.value.toString())
        this.status = PaymentStatus.AWAITING_PAYMENT
        this.dueDate = FormatUtils.toDate(params.dueDate.toString(), "yyyy-MM-dd")
    }
}
