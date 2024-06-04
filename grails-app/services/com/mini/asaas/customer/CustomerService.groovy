package com.mini.asaas.customer

import com.mini.asaas.user.UserAdapter
import com.mini.asaas.user.UserService

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@GrailsCompileStatic
@Transactional
class CustomerService {

    UserService userService

    public Customer save(CustomerAdapter customerAdapter, UserAdapter userAdapter) {
        Customer customer = new Customer()

        customer.cpfCnpj = customerAdapter.cpfCnpj
        customer.personType = customerAdapter.personType
        buildCustomerProperties(customer, customerAdapter)

        customer.save(failOnError: true)
        userService.saveCustomerUser(userAdapter, customer.id)

        return customer
    }

    public Customer update(Long customerId, CustomerAdapter adapter) {
        Customer customer = Customer.get(customerId)

        buildCustomerProperties(customer, adapter)

        customer.save(failOnError: true)

        return customer
    }

    private buildCustomerProperties(Customer customer, CustomerAdapter adapter) {
        customer.name = adapter.name
        customer.email = adapter.email
        customer.phone = adapter.phone
        customer.mobilePhone = adapter.mobilePhone
        customer.postalCode = adapter.postalCode
        customer.address = adapter.address
        customer.addressNumber = adapter.addressNumber
        customer.addressComplement = adapter.addressComplement
        customer.district = adapter.district
        customer.city = adapter.city
        customer.state = adapter.state
    }
}