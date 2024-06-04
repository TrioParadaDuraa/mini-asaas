package com.mini.asaas.utils.validators

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class MobilePhoneValidator {
    
    public static Boolean isValidMobilePhone(String mobilePhone) {
        if (mobilePhone.matches(/[0-9]{11}/) && mobilePhone.charAt(2) == '9') {
            return true
        }

        return false
    }
}
