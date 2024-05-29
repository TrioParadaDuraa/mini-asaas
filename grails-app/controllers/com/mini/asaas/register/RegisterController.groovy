package com.mini.asaas.register

import com.mini.asaas.customer.Customer
import com.mini.asaas.customer.CustomerAdapter
import com.mini.asaas.customer.CustomerService
import com.mini.asaas.user.UserAdapter

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class RegisterController {

    CustomerService customerService

    def index() {}

    def save() {
        try {
            CustomerAdapter customerAdapter = new CustomerAdapter(params)
            UserAdapter userAdapter = new UserAdapter(params)

            Customer customer = customerService.save(customerAdapter, userAdapter)

            redirect(controller:"customer", action: "show", id: customer.id)
        } catch (Exception exception) {
            log.error("CustomerController.save >> Erro ao cadastrar cliente", exception)
            flash.message = 'Erro ao salvar os dados, verifique todos os campos e tente novamente.'

            redirect(action: "index")
         }
    }
}
