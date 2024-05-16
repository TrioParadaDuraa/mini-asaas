package com.mini.asaas.utils.validators

class PostalcodeValidator {

    public static boolean isValidPostalcode(String postalCode) {
        if (postalCodeDigits.length() != 8) {
            return false
        }

        if (postalCodeDigits.replaceAll("(.)\\1*", "").length() == 1) {
            return false
        }

        return true
    }
}