package com.mini.asaas.payer

import com.mini.asaas.domain.base.BasePersonAdapter
import com.mini.asaas.utils.base.PersonType

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class PayerAdapter extends BasePersonAdapter {

    public PayerAdapter(Map params) {
        this.cpfCnpj = params.cpfCnpj
        this.name = params.name
        this.email = params.email
        this.phone = params.phone
        this.mobilePhone = params.mobilePhone
        this.personType = PersonType.convert(params.personType.toUpperCase())
        this.postalCode = params.postalCode
        this.address = params.address
        this.addressNumber = params.addressNumber
        this.addressComplement = (params.addressComplement.trim()) ? params.addressComplement : null
        this.district = params.district
        this.city = params.city
        this.state = params.state
    }
}
