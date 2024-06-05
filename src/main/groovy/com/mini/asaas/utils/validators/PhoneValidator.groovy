package com.mini.asaas.utils.validators

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class PhoneValidator {
    
    public static Boolean isValidPhone(String phone) {
        if (phone.matches(/[0-9]{10}/)) {
            return true
        }

        return false
    }
}
