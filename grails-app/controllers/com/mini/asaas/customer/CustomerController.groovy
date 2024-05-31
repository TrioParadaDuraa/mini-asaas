package com.mini.asaas.customer

import com.mini.asaas.user.User
import com.mini.asaas.user.UserAdapter
import com.mini.asaas.utils.message.MessageType

import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

@GrailsCompileStatic
@Secured("isAuthenticated()")
class CustomerController {
    
    CustomerService customerService

    SpringSecurityService springSecurityService

    @Secured("permitAll")
    def index() {}

    @Secured("permitAll")
    def save() {
        try {
            CustomerAdapter customerAdapter = new CustomerAdapter(params)
            UserAdapter userAdapter = new UserAdapter(params)

            Customer customer = customerService.save(customerAdapter, userAdapter)

            redirect(action: "show")
        } catch (Exception exception) {
            log.error("CustomerController.save >> Erro ao cadastrar cliente", exception)
            flash.type = MessageType.ERROR
            flash.message = 'Erro ao salvar os dados, verifique todos os campos e tente novamente.'

            redirect(action: "index")
         }
    }

    def show() {
        try {
            User user = (User) springSecurityService.currentUser

            Customer customer = Customer.read(user.customer.id)

            if (!customer) {
                throw new Exception("Cliente não encontrado")
            }

            return [customer: customer]
       } catch (Exception exception) {
            log.error("CustomerController.show >> Cliente não encontrado", exception)
            render "Cliente não encontrado"
        }
    }

    @Secured("isFullyAuthenticated()")
    def update() {
        try {
            User user = (User) springSecurityService.currentUser
            Long customerId = user.customer.id

            CustomerAdapter adapter = new CustomerAdapter(params)
            customerService.update(customerId, adapter)

            redirect(action: "show", id: customerId)
        } catch (Exception exception) {
            log.error("CustomerController.update >> Não foi possível salvar as atualizações", exception)
            render "Não foi possível atualizar os dados"
        }
    }
}