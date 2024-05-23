package com.mini.asaas.payment

import com.mini.asaas.utils.FormatUtils
import com.mini.asaas.utils.enums.PaymentStatus
import com.mini.asaas.utils.enums.PaymentType

class PaymentAdapter {

    PaymentType paymentType

    BigDecimal value

    PaymentStatus status

    Date dueDate

    public PaymentAdapter(Map params) {
        this.paymentType = params.paymentType
        this.value = FormatUtils.toBigDecimal(params.value)
        this.status = PaymentStatus.AWAITING_PAYMENT
        this.dueDate = FormatUtils.toDate(params.dueDate, "yyyy-MM-dd")
    }
}
