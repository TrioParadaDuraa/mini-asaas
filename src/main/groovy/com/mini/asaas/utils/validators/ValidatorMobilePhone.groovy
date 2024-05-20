package com.mini.asaas.utils.validators

class ValidatorMobilePhone {
    public static boolean isValidMobilePhone(String mobilePhone) {
        if (mobilePhone.matches("[0-9]{11}") && mobilePhone.charAt(2) == '9') {
            return true
        }

        return false
    }
}
