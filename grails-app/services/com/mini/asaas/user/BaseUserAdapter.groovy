package com.mini.asaas.user

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class BaseUserAdapter {

    String password
    
    String passwordConfirm

    public BaseUserAdapter(Map params) {
        this.password = params.password
        this.passwordConfirm = params.passwordConfirm
    }
}
