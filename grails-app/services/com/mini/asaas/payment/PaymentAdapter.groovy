package com.mini.asaas.payment

import com.mini.asaas.utils.enums.PaymentStatus
import com.mini.asaas.utils.enums.PaymentType

class PaymentAdapter {

    PaymentType paymentType

    String value

    PaymentStatus status

    Date dueDate

    public PaymentAdapter(Map params) {
        this.paymentType = params.paymentType
        this.value = params.value
        this.status = PaymentStatus.AWAITING_PAYMENT
        this.dueDate = params.dueDate
    }
}
