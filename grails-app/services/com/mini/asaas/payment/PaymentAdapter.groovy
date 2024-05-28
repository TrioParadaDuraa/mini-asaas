package com.mini.asaas.payment

import com.mini.asaas.utils.FormatUtils
import com.mini.asaas.utils.Utils
import com.mini.asaas.utils.enums.PaymentStatus
import com.mini.asaas.utils.enums.PaymentType

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class PaymentAdapter {

    Long customerId

    Long payerId

    PaymentType paymentType

    BigDecimal value

    PaymentStatus status

    Date dueDate

    public PaymentAdapter(Map params) {
        this.customerId = 1
        this.payerId = 1
        this.paymentType = PaymentType.convert(params.paymentType.toUpperCase())
        this.value = Utils.toBigDecimal(params.value)
        this.status = PaymentStatus.AWAITING_PAYMENT
        this.dueDate = FormatUtils.toDate(params.dueDate, "yyyy-MM-dd")
    }
}
