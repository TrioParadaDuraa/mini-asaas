package com.mini.asaas.customer

import grails.gorm.transactions.Transactional

@Transactional
class CustomerService {

    public Customer save(CustomerAdapter adapter){
        Customer customer = new Customer()

        customer.cpfCnpj = adapter.cpfCnpj
        customer.name = adapter.name
        customer.email = adapter.email
        customer.phone = adapter.phone
        customer.personType = adapter.personType
        customer.postalCode = adapter.postalCode
        customer.address = adapter.address
        customer.addressNumber = adapter.addressNumber
        customer.addressComplement = adapter.addressComplement
        customer.district = adapter.district
        customer.city = adapter.city
        customer.state = adapter.state

        customer.save(failOnError: true)

        return customer
    }

    public Customer update(Long customerId, params){
        Customer customer = Customer.get(customerId)

        customer.cpfCnpj = params.cpfCnpj
        customer.name = params.name
        customer.email = params.email
        customer.phone = params.phone
        customer.postalCode = params.postalCode
        customer.address = params.address
        customer.addressNumber = params.addressNumber
        customer.addressComplement = params.addressComplement
        customer.district = params.district
        customer.city = params.city
        customer.state = params.state

        println(customer.addressNumber)
        println(params.addressNumber)

        customer.save(failOnError: true)

        return customer
    }
}