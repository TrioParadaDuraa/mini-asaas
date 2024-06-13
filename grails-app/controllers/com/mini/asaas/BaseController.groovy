package com.mini.asaas

import com.mini.asaas.user.User

import grails.plugin.springsecurity.SpringSecurityService

abstract class BaseController {

    SpringSecurityService springSecurityService

    protected Long getCurrentCustomerId() {
        return springSecurityService.currentUser.customer.id
    }

    protected User getCurrentUser() {
        return springSecurityService.currentUser
    }
}
