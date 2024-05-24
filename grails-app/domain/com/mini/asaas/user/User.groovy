package com.mini.asaas.user

import com.mini.asaas.customer.Customer
import com.mini.asaas.domain.base.BaseDomain

import grails.compiler.GrailsCompileStatic

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
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
        password nullable: false, blank: false, password: true, validator: { String password, User user ->
            return password == user.passwordConfirm
        }
    }

    static mapping = {
        table '`user`'
        username unique: true
        password column: '`password`'
    }

    static transients = ["passwordConfirm"]
}
