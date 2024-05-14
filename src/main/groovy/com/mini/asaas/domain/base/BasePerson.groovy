package com.mini.asaas.domain.base

import com.mini.asaas.utils.base.PersonType

abstract class BasePerson {

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

    static constraints = {
        cpfCnpj size: 11..14, blank: false
        name blank: false
        email email: true, blank: false
        phone blank: false, size: 10..11
        postalCode blank: false, size: 8..8
        address blank: false
        addressNumber blank: false
        addressComplement blank: false, nullable: true
        district blank: false
        city blank: false
        state blank: false, size: 2..2
    }
}
