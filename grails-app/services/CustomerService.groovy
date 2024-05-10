package com.mini.asaas

import com.mini.asaas.domain.Customer
import com.mini.asaas.PersonType
import com.mini.asaas.utils.CustomerAdapter
import grails.gorm.transactions.Transactional

@Transactional
class CustomerService {
    public Customer save(CustomerAdapter adapter){
        Customer customer = adapter.toCustomer()
        customer.save(failOnError: true)
        return customer
    }
}