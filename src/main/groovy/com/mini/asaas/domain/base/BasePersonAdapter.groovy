package com.mini.asaas.domain.base

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
abstract class BasePersonAdapter {

    String name

    String email

    String phone

    String mobilePhone

    String postalCode

    String address

    String addressNumber

    String addressComplement

    String district

    String city

    String state
}
