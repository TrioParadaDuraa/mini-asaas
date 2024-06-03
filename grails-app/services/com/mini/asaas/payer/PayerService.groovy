package com.mini.asaas.payer

import com.mini.asaas.customer.Customer

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@GrailsCompileStatic
@Transactional
class PayerService {

    public Payer save(PayerAdapter adapter, Long customerId) {
        Payer payer = new Payer()

        buildPayerProperties(payer, adapter)
        payer.customer = Customer.read(customerId)

        payer.save(failOnError: true)
        
        return payer
    }

    public Payer update(Long payerId, PayerAdapter adapter) {
        Payer payer = Payer.get(payerId)

        buildPayerProperties(payer, adapter)

        payer.save(failOnError: true)
        
        return payer
    }

    public void delete(Long payerId) {
        Payer payer = Payer.get(payerId)

        payer.deleted = true

        payer.save(failOnError: true)
    }

    public void restore(Long payerId) {
        Payer payer = Payer.get(payerId)

        payer.deleted = false

        payer.save(failOnError: true)
    }

    private void buildPayerProperties(Payer payer, PayerAdapter adapter) {
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
    }
}
