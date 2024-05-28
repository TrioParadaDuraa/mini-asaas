package com.mini.asaas.domain.base

import com.mini.asaas.utils.base.PersonType

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
abstract class BasePersonAdapter {

    String cpfCnpj

    String name

    String email

    String phone

    String mobilePhone

    PersonType personType

    String postalCode

    String address

    String addressNumber

    String addressComplement

    String district

    String city

    String state
}
