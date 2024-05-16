package com.mini.asaas.payer

import com.mini.asaas.customer.Customer
import grails.gorm.transactions.Transactional

@Transactional
class PayerService {

    public Payer save(PayerAdapter adapter, Long customerId) {
        Payer payer = new Payer()

        payer.customer = Customer.get(customerId)
        payer.cpfCnpj = adapter.cpfCnpj
        payer.name = adapter.name
        payer.email = adapter.email
        payer.phone = adapter.phone
        payer.personType = adapter.personType
        payer.postalCode = adapter.postalCode
        payer.address = adapter.address
        payer.addressNumber = adapter.addressNumber
        payer.addressComplement = adapter.addressComplement
        payer.district = adapter.district
        payer.city = adapter.city
        payer.state = adapter.state

        payer.save(failOnError: true)
        
        return payer
    }
}
