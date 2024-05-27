package com.mini.asaas.utils.enums

import com.mini.asaas.utils.Utils

enum PaymentType {

    BANK_SLIP,
    CREDIT_CARD,
    PIX,
    MONEY

    public static PaymentType convert(paymentType) {
        try {
            return paymentType as PaymentType
        } catch (Exception exception) {
            return null
        }
    }

    public String getLabel() {
        Utils.getMessageProperty("PaymentType.${this}.label", null)
    }
}