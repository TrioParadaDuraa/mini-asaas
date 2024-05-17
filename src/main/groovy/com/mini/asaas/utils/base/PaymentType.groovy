package com.mini.asaas.utils.base

enum PaymentType {

    BANK_SLIP,
    CREDIT_CARD,
    PIX

    public static PaymentType convert(paymentType) {
        try {
            return paymentType as PaymentType
        } catch (Exception exception) {
            return null
        }
    }
}