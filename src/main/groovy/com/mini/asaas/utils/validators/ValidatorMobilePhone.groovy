package com.mini.asaas.utils.validators

class ValidatorMobilePhone {
    public static boolean isValidMobilePhone(String mobilePhone) {
        if (mobilePhone.length() != 11) {
            return false
        }

        if (mobilePhone[2] != '9') {
            return false
        }

        return true
    }
}
