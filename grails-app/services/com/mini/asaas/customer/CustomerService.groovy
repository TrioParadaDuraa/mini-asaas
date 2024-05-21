package com.mini.asaas.customer

import grails.gorm.transactions.Transactional

@Transactional
class CustomerService {

    public Customer save(CustomerAdapter adapter){
        Customer customer = new Customer()

        buildCustomerPropertiers(customer, adapter)

        customer.save(failOnError: true)

        return customer
    }

    public Customer update(Long customerId, CustomerAdapter adapterUpdate){
        Customer customer = Customer.get(customerId)

        buildCustomerPropertiers(customer, adapterUpdate)

        customer.save(failOnError: true)

        return customer
    }

    private Customer buildCustomerPropertiers(Customer customer, CustomerAdapter adapter) {

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

        return customer
    }
}