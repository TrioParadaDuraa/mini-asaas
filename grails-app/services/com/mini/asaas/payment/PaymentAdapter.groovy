package com.mini.asaas.payment

import com.mini.asaas.payer.Payer
import com.mini.asaas.utils.base.PaymentStatus
import com.mini.asaas.utils.base.PaymentType

class PaymentAdapter {

    Payer payer
    PaymentType paymentType
    BigDecimal value
    PaymentStatus status
    Date dueDate

    public PaymentAdapter(Map params) {
        this.payer = params.payer
        this.paymentType = PaymentType.convert(params.paymentType.toUpperCase())
        this.value = params.value
        this.status = params.status
        this.dueDate = params.dueDate
    }
}
