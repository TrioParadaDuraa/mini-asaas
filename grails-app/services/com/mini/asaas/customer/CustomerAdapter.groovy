package com.mini.asaas.customer

import com.mini.asaas.domain.base.BasePersonAdapter
import com.mini.asaas.utils.base.PersonType

class CustomerAdapter {

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

    public CustomerAdapter(Map params){
        this.cpfCnpj = params.cpfCnpj
        this.name = params.name
        this.email = params.email
        this.phone = params.phone
        this.mobilePhone = params.mobilePhone
        this.personType = PersonType.NATURAL
        this.postalCode = params.postalCode
        this.address = params.address
        this.addressNumber = params.addressNumber
        this.addressComplement = (params.addressComplement.trim()) ? params.addressComplement : null
        this.district = params.district
        this.city = params.city
        this.state = params.state
    }
}
