package com.mini.asaas

import com.mini.asaas.utils.BasePerson
import com.mini.asaas.PersonType

class Customer extends BasePerson {

    String name
    String email
    PersonType personType

    static constraints = {
        name blank: false
        email email:true, blank: false
    }
}