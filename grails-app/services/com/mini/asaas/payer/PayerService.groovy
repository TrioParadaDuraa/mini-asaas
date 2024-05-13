package com.mini.asaas.payer

import com.mini.asaas.domain.Customer
import com.mini.asaas.PersonType
import grails.gorm.transactions.Transactional

@Transactional
class PayerService {

    public Payer save(Map params) {
        Payer payer = new Payer()
        payer.cpfCnpj = params.cpfCnpj
        payer.name = params.name
        payer.email = params.email
        payer.postalCode = params.postalCode
        payer.address = params.address
        payer.city = params.city
        payer.state = params.state
        payer.personType = PersonType.NATURAL
        payer.customer = Customer.get(params.long("customerId"))

        payer.save(failOnError: true)
        return payer
    }

}
