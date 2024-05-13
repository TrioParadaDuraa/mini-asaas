package com.mini.asaas.payer

import com.mini.asaas.domain.Customer
import grails.gorm.transactions.Transactional

@Transactional
class PayerService {

    public Payer save(Map params) {
        PayerAdapter adapter = new PayerAdapter(params)
        Payer payer = new Payer()

        payer.cpfCnpj = adapter.cpfCnpj
        payer.name = adapter.name
        payer.email = adapter.email
        payer.postalCode = adapter.postalCode
        payer.address = adapter.address
        payer.city = adapter.city
        payer.state = adapter.state
        payer.personType = adapter.personType
        payer.customer = Customer.get(adapter.customerId)

        payer.save(failOnError: true)
        
        return payer
    }

}
