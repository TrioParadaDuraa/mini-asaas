package com.mini.asaas.utils.base

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