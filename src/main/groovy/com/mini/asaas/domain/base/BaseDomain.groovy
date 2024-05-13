package com.mini.asaas.domain.base

abstract class BaseDomain {

    Date dateCreated
    Date lastUpdated
    Boolean deleted = false

    static mapping = {
        tablePerHierarchy false
    }
}