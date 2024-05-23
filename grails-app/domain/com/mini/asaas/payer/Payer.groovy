package com.mini.asaas.payer

import com.mini.asaas.customer.Customer
import com.mini.asaas.domain.base.BasePerson

class Payer extends BasePerson {

    Customer customer

    static namedQueries = {
        query { Customer customer, Map filterList ->
            if (Boolean.valueOf(filterList.deleted)) {
                eq "deleted", true
            } else if (!Boolean.valueOf(filterList.deleted)) {
                eq "deleted", false
            }

            eq "customer", customer
        }
    }
}
