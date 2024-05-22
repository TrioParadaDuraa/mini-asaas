package com.mini.asaas.utils.validators

class PostalCodeValidator {

    public static boolean isValidPostalCode(String postalCode) {
        if (!postalCode.matches("\\d{8}") || postalCode.matches("(.)\\1{7}")) {
            return false
        }

        return true
    }
}
