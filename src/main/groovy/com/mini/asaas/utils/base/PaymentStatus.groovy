package com.mini.asaas.utils.base

import com.mini.asaas.utils.enums.PaymentType

enum PaymentStatus {

    AWAITING_PAYMENT,
    RECEIVED,
    OVERDUE,
    CANCELED

    public static PaymentType convert(paymentType) {
        try {
            return paymentType as PaymentType
        } catch (Exception exception) {
            return null
        }
    }
}