package com.mini.asaas.payer

import com.mini.asaas.customer.Customer
import com.mini.asaas.domain.base.BasePerson

class Payer extends BasePerson {

    Customer customer

    static namedQueries = {
        query { Map filterList ->
            if (Boolean.valueOf(filterList.deleted)) {
                eq("deleted", true)
            } else {
                eq("deleted", false)
            }

            if (filterList.containsKey("customerId")) {
                eq("customer.id", filterList.customerId)
            }
        }
    }
}
