package com.mini.asaas.utils.validators

import com.mini.asaas.user.User

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class PasswordValidator {
    
    static int MIN_PASSWORD_SIZE = 8

    public static Closure validate() {
        return { String password, User user ->
            return matches(password, user.passwordConfirm) && isStrong(password)
        }
    }

    public static boolean matches(String password, String passwordConfirm) {
        return password == passwordConfirm
    }

    public static boolean isStrong(String password) {
        return (password.size() >= MIN_PASSWORD_SIZE) && hasCharsAndDigits(password)
    }

    private static boolean hasCharsAndDigits(String password) {
        return password.find(/[a-zA-Z]/) && password.find(/[0-9]/)
    } 
}
