package com.mini.asaas.notification

import com.mini.asaas.customer.Customer
import com.mini.asaas.domain.base.BaseDomain
import com.mini.asaas.payment.Payment

class Notification extends BaseDomain {

    Customer customer

    Payment payment

    String title

    String description

    static constraints = {
        title blank: false
    }

    static namedQueries = {
        query { Map filterList ->
            eq("customer.id", filterList.customerId)
        }
    }
}
