package com.mini.asaas.payment

import com.mini.asaas.customer.Customer
import com.mini.asaas.domain.base.BaseDomain
import com.mini.asaas.payer.Payer
import com.mini.asaas.utils.enums.PaymentStatus
import com.mini.asaas.utils.enums.PaymentType

class Payment extends BaseDomain {

    Customer customer

    Payer payer

    PaymentType paymentType

    BigDecimal value

    PaymentStatus status

    Date dueDate

    static constraints = {
        value blank: false, nullable: false, scale: 2
        dueDate blank: false, date: true
    }
}
