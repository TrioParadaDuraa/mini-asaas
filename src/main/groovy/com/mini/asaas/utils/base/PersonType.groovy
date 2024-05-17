package com.mini.asaas.utils.base

import com.mini.asaas.utils.Utils

enum PersonType {

    NATURAL,
    LEGAL

    public static PersonType convert(personType) {
        try {
            return personType as PersonType
        } catch (Exception exception) {
            return null
        }
    }

    public String getLabel() {
        Utils.getMessageProperty("PersonType.${this}.label", null)
    }
}