package com.mini.asaas.utils.enums

import com.mini.asaas.utils.Utils

enum PaymentStatus {

    AWAITING_PAYMENT,
    RECEIVED,
    OVERDUE,
    CANCELED,
    RECEIVED_IN_CASH

    public static PaymentStatus convert(paymentStatus) {
        try {
            return paymentStatus as PaymentStatus
        } catch (Exception exception) {
            return null
        }
    }

    public String getLabel() {
        Utils.getMessageProperty("PaymentStatus.${this}.label", null)
    }
}