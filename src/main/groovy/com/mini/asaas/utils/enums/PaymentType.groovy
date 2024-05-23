package com.mini.asaas.utils.enums

import com.mini.asaas.utils.Utils

enum PaymentType {

    BANK_SLIP,
    CREDIT_CARD,
    PIX

    public String getLabel() {
        Utils.getMessageProperty("PaymentType.${this}.label", null)
    }
}