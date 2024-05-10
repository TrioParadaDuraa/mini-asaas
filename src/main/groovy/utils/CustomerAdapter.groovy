package com.mini.asaas.utils

import com.mini.asaas.domain.Customer
import com.mini.asaas.PersonType

class CustomerAdapter {

        String cpfCnpj
        String name
        String email
        String postalCode
        String address
        String city
        String state
        PersonType personType

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