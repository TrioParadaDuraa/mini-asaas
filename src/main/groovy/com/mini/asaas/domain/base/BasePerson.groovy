package com.mini.asaas.domain.base

import com.mini.asaas.utils.base.PersonType

abstract class BasePerson {

    String cpfCnpj
    String name
    String email
    String phoneNumber
    PersonType personType
    String postalCode
    String address
    String addressNumber
    String district
    String complement
    String city
    String state

    static constraints = {
        cpfCnpj size: 11..14, blank: false
        name blank: false
        email email: true, blank: false
        complement blank: true, nullable: true
        city blank: false
        state blank: false, size: 2..2
        district blank: false
        addressNumber blank: true, nullable: true
        address blank: false
        postalCode blank: false, size: 8..8
        phoneNumber blank: false
    }

}
