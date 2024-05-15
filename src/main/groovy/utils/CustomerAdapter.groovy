package com.mini.asaas.utils

import com.mini.asaas.domain.Customer
import com.mini.asaas.domain.base.BasePersonAdapter
import com.mini.asaas.utils.base.PersonType

class CustomerAdapter extends BasePersonAdapter {

    Customer toCustomer(){
        Customer customer = new Customer(cpfCnpj: cpfCnpj, 
        name: name, 
        email: email, 
        postalCode: postalCode, 
        address: address, 
        city: city, 
        state: state, 
        personType: personType.NATURAL)
        return customer
    }

}

