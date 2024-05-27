package com.mini.asaas.user

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class UserAdapter {

    String username

    String password
    
    String passwordConfirm

    public UserAdapter(Map params) {
        this.username = params.email
        this.password = params.password
        this.passwordConfirm = params.passwordConfirm
    }
}
