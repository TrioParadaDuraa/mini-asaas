package com.mini.asaas.payer

import com.mini.asaas.customer.Customer

import grails.gorm.transactions.Transactional

@Transactional
class PayerService {

    public Payer save(PayerAdapter adapter, Customer customer) {
        Payer payer = new Payer()

        payer.customer = customer
        payer.cpfCnpj = adapter.cpfCnpj
        payer.name = adapter.name
        payer.email = adapter.email
        payer.phone = adapter.phone
        payer.mobilePhone = adapter.mobilePhone
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

    public List<Payer> list(Long customerId, Map filterList) {
        filterList.customerId = customerId

        return Payer.query(filterList).list()
    }

    public Payer update(Payer payer, PayerAdapter adapter) {
        payer.cpfCnpj = adapter.cpfCnpj
        payer.name = adapter.name
        payer.email = adapter.email
        payer.phone = adapter.phone
        payer.mobilePhone = adapter.mobilePhone
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

    public void delete(Payer payer) {
        payer.deleted = true

        payer.save(failOnError: true)
    }

    public void restore(Payer payer) {
        payer.deleted = false

        payer.save(failOnError: true)
    }
}
