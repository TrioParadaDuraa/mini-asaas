
package com.mini.asaas

import com.mini.asaas.domain.Customer
import com.mini.asaas.utils.CustomerAdapter

class CustomerController {
    
    def customerService

    def index () {

    }

    def save() {
        try {
            CustomerAdapter adapter = new CustomerAdapter(params)
            Customer customer = customerService.save(adapter)
            redirect(action: "show", id: customer.id)
        } catch (Exception e) {
            println(e)
            render "Não foi possível salvar"
        }
}

    def show() {
        try {
            Customer customer = Customer.get(params.id)
            if (!customer) {
                render "Cliente não encontrado"
            }
                return [customer: customer]
       } catch (Exception e) {
           render "Cliente não encontrado"
       }

    }
}