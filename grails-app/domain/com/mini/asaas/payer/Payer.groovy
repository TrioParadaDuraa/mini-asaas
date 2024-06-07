package com.mini.asaas.payer

import com.mini.asaas.customer.Customer
import com.mini.asaas.domain.base.BasePerson

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Payer extends BasePerson {

    Customer customer

    static namedQueries = {
        query { Map filterList ->
            if (filterList.deleted == "true") {
                eq("deleted", true)
            } else {
                eq("deleted", false)
            }
            
            if (filterList.containsKey("customerId")) {
                eq("customer.id", filterList.customerId)
            }

            if (filterList.containsKey("id")) {
                eq("id", filterList.id)
            }
        }
    }
}
