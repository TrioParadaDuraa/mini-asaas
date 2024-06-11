package com.mini.asaas.user

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class CreateUserAdapter extends BaseUserAdapter {

    String username

    public CreateUserAdapter(Map params) {
        super(params)
        this.username = params.email
    }
}
