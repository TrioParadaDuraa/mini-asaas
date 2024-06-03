package com.mini.asaas.payment

import com.mini.asaas.customer.Customer
import com.mini.asaas.domain.base.BaseDomain
import com.mini.asaas.payer.Payer
import com.mini.asaas.utils.enums.PaymentStatus
import com.mini.asaas.utils.enums.BillingType

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Payment extends BaseDomain {

    Customer customer

    Payer payer

    BillingType billingType

    BigDecimal value

    PaymentStatus status

    Date dueDate

    static constraints = {
        value blank: false, nullable: false, scale: 2
        dueDate blank: false, date: true
    }

    static namedQueries = {
        query { Map filterList ->
            if (filterList.containsKey("customerId")) {
                eq("customer.id", filterList.customerId)
            }

            if (filterList.containsKey("payerId")) {
                eq("payer.id", filterList.payerId)
            }

            if (filterList.containsKey("id")) {
                eq("id", filterList.id)
            }
        }

        overdueIds {
            projections {
                property('id')
            }
            lt('dueDate', new Date())
            not {
                inList('status', [PaymentStatus.RECEIVED, PaymentStatus.RECEIVED_IN_CASH, PaymentStatus.OVERDUE])
            }
        }
    }
}
