package com.mini.asaas.utils.validators

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class EmailValidator {
    public static boolean isValidEmail(String email) {
        if (email.matches("^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$")) {
            return true
        }

        return false
    }
}
