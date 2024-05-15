package com.mini.asaas.customer

import com.mini.asaas.utils.base.PersonType

class CustomerAdapter {

    String cpfCnpj

    String name

    String email

    String phone

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
        this.personType = PersonType.NATURAL
        this.postalCode = params.postalCode
        this.address = params.address
        this.addressNumber = params.addressNumber
        this.addressComplement = params.addressComplement
        this.district = params.district
        this.city = params.city
        this.state = params.state
    }
}