package com.mini.asaas.user

import com.mini.asaas.customer.Customer
import com.mini.asaas.domain.base.BaseDomain
import com.mini.asaas.utils.validators.PasswordValidator

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class User extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1

    String username

    String password

    String passwordConfirm

    Customer customer

    boolean enabled = true

    boolean accountExpired

    boolean accountLocked

    boolean passwordExpired

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        username nullable: false, blank: false, email: true
        password nullable: false, blank: false, password: true, validator: PasswordValidator.validate()
    }

    static mapping = {
        table "`user`"
        username unique: true
        password column: "`password`"
    }

    static transients = ["passwordConfirm"]

    static namedQueries = {
        query { Map filterList ->
            if (filterList.containsKey("customerId")) {
                eq("customer.id", filterList.customerId)
            }

            if (filterList.containsKey("id")) {
                eq("id", filterList.id)
            }
        }
    }
}
