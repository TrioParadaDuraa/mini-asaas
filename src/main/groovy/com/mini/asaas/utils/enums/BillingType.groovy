package com.mini.asaas.utils.enums

import com.mini.asaas.utils.Utils

enum BillingType {

    BANK_SLIP,
    CREDIT_CARD,
    PIX

    public static BillingType convert(billingType) {
        try {
            return billingType as BillingType
        } catch (Exception exception) {
            return null
        }
    }

    public String getLabel() {
        Utils.getMessageProperty("PaymentType.${this}.label", null)
    }
}