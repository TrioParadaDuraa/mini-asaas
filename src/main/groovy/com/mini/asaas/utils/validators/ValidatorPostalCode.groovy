package com.mini.asaas.utils.validators

class PostalCodeValidator {

    public static boolean isValidPostalCode(String postalCode) {
        if (postalCode.length() != 8) {
            return false
        }

        if (postalCode.replaceAll("(.)\\1*", "").length() == 1) {
            return false
        }

        return true
    }
}