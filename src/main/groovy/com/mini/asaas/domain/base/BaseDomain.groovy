package com.mini.asaas.domain.base

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
abstract class BaseDomain {

    Date dateCreated

    Date lastUpdated

    Boolean deleted = false

    static mapping = {
        tablePerHierarchy false
    }
}