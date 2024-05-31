package com.mini.asaas.customer

import com.mini.asaas.domain.base.BasePersonAdapter
import com.mini.asaas.utils.Utils
import com.mini.asaas.utils.base.PersonType

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class CreateCustomerAdapter extends BasePersonAdapter {

    String cpfCnpj

    PersonType personType

    public CreateCustomerAdapter(Map params){
        this.cpfCnpj = Utils.removeNoNumeric(params.cpfCnpj.toString())
        this.name = params.name
        this.email = params.email
        this.phone = Utils.removeNoNumeric(params.phone.toString())
        this.mobilePhone = Utils.removeNoNumeric(params.mobilePhone.toString())
        this.personType = PersonType.convert(params.personType.toString().toUpperCase())
        this.postalCode = Utils.removeNoNumeric(params.postalCode.toString())
        this.address = params.address
        this.addressNumber = params.addressNumber
        this.addressComplement = (params.addressComplement.toString().trim()) ? params.addressComplement : null
        this.district = params.district
        this.city = params.city
        this.state = params.state
    }
}
