package com.mini.asaas.payment

import com.mini.asaas.domain.base.BaseDomain
import com.mini.asaas.payer.Payer
import com.mini.asaas.utils.base.PaymentStatus
import com.mini.asaas.utils.enums.PaymentType

class Payment extends BaseDomain{

    Payer payer
    PaymentType paymentType
    BigDecimal value
    PaymentStatus status
    Date dueDate

    static constraints = {
    }
}
