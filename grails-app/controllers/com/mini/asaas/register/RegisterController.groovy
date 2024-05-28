package com.mini.asaas.register

import com.mini.asaas.customer.Customer
import com.mini.asaas.customer.CustomerAdapter
import com.mini.asaas.customer.CustomerService
import com.mini.asaas.user.UserAdapter
import com.mini.asaas.user.UserService

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class RegisterController {

    CustomerService customerService
    UserService userService

    def index() {}

    def save() {
        try {
            CustomerAdapter customerAdapter = new CustomerAdapter(params)
            UserAdapter userAdapter = new UserAdapter(params)

            Customer customer = customerService.save(customerAdapter)
            userService.saveCustomerUser(userAdapter, customer.id)

            redirect(controller:"customer", action: "show", id: customer.id)
        } catch (Exception exception) {
            log.error("CustomerController.save >> Erro ao cadastrar cliente", exception)
            flash.message = 'Erro ao salvar os dados, verifique todos os campos e tente novamente.'

            redirect(action: "index")
         }
    }
}
