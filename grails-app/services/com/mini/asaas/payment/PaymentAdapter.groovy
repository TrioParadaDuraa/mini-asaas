package com.mini.asaas.payment

import com.mini.asaas.customer.Customer
import com.mini.asaas.domain.base.BaseDomain
import com.mini.asaas.payer.Payer
import com.mini.asaas.utils.base.PaymentStatus
import com.mini.asaas.utils.enums.PaymentType

class PaymentAdapter extends BaseDomain{

    Customer customer

    Payer payer

    PaymentType paymentType

    BigDecimal value

    PaymentStatus status

    Date dueDate

    public PaymentAdapter(Map params) {
        this.customer = params.customer
        this.payer = params.payer
        this.paymentType = PaymentType.convert(params.paymentType.toUpperCase())
        this.value = params.value
        this.status = params.status
        this.dueDate = params.dueDate
    }
}
