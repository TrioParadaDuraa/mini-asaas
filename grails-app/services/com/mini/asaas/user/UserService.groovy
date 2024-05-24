package com.mini.asaas.user

import com.mini.asaas.customer.Customer

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    public User save(UserAdapter adapter, Long customerId) {
        User user = new User()

        user.customer = Customer.read(customerId)
        user.username = adapter.username
        user.password = adapter.password

        user.save(failOnError: true)

        return user
    }
}
