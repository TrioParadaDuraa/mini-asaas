package com.mini.asaas.utils.enums

import com.mini.asaas.utils.Utils

enum PaymentStatus {

    AWAITING_PAYMENT,
    RECEIVED,
    OVERDUE,
    CANCELED,
    MONEY

    public static PaymentType convert(paymentType) {
        try {
            return paymentType as PaymentType
        } catch (Exception exception) {
            return null
        }
    }

    public String getLabel() {
        Utils.getMessageProperty("PaymentStatus.${this}.label", null)
    }
}