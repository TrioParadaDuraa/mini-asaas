package com.mini.asaas.customer

import grails.gorm.transactions.Transactional

@Transactional
class CustomerService {

    public Customer save(CustomerAdapter adapter) {
        Customer customer = new Customer()

        buildCustomerProperties(customer, adapter)

        customer.save(failOnError: true)

        return customer
    }

    public update(Long customerId, CustomerAdapter adapter) {
        Customer customer = Customer.get(customerId)

        buildCustomerProperties(customer, adapter)

        customer.save(failOnError: true)
    }

    private buildCustomerProperties(Customer customer, CustomerAdapter adapter) {
        customer.cpfCnpj = adapter.cpfCnpj
        customer.name = adapter.name
        customer.email = adapter.email
        customer.phone = adapter.phone
        customer.mobilePhone = adapter.mobilePhone
        customer.personType = adapter.personType
        customer.postalCode = adapter.postalCode
        customer.address = adapter.address
        customer.addressNumber = adapter.addressNumber
        customer.addressComplement = adapter.addressComplement
        customer.district = adapter.district
        customer.city = adapter.city
        customer.state = adapter.state
    }
}