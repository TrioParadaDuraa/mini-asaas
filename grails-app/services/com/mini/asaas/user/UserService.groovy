package com.mini.asaas.user

import com.mini.asaas.customer.Customer

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@GrailsCompileStatic
@Transactional
class UserService {

    public User saveCustomerUser(UserAdapter adapter, Long customerId) {
        User user = new User()

        user.customer = Customer.read(customerId)
        user.username = adapter.username
        user.password = adapter.password
        user.passwordConfirm = adapter.passwordConfirm

        user.save(failOnError: true)

        Role role = Role.findByAuthority("ROLE_CUSTOMER")
        UserRole.create(user, role)

        return user
    }
}
