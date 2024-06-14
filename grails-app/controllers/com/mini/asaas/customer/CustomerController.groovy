package com.mini.asaas.customer

import com.mini.asaas.BaseController
import com.mini.asaas.user.CreateUserAdapter
import com.mini.asaas.utils.message.MessageType

import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

@GrailsCompileStatic
class CustomerController extends BaseController {
    
    CustomerService customerService

    @Secured("permitAll")
    def index() {}

    @Secured("permitAll")
    def save() {
        try {
            CreateCustomerAdapter customerAdapter = new CreateCustomerAdapter(params)
            CreateUserAdapter userAdapter = new CreateUserAdapter(params)

            Customer customer = customerService.save(customerAdapter, userAdapter)

            redirect(controller: "login", action: "auth")
        } catch (ValidationException validationException) {
            log.error("CustomerController.save >> Erro ao cadastrar cliente", validationException)

            def errorMessage = "Erro ao salvar os dados, verifique todos os campos e tente novamente."
            if (validationException.errors) {
                errorMessage = validationException.errors.allErrors.collect { it.defaultMessage }.join(', ')
            }

            flash.type = MessageType.ERROR
            flash.message = errorMessage

            redirect(action: "index")
        }
    }

    @Secured("isAuthenticated()")
    def show() {
        try {
            Customer customer = Customer.read(getCurrentCustomerId())

            if (!customer) throw new Exception("Cliente não encontrado")

            return [customer: customer]
        } catch (Exception exception) {
            log.error("CustomerController.show >> Cliente não encontrado", exception)
            render "Cliente não encontrado"
        }
    }

    @Secured("isAuthenticated()")
    def edit() {
        try {
            Customer customer = Customer.read(getCurrentCustomerId())

            if (!customer) throw new Exception("Cliente não encontrado para edição")

            return [customer: customer]
        } catch (Exception exception) {
            log.error("CustomerController.edit >> Cliente não encontrado para edição", exception)
            render "Cliente não encontrado para edição"
        }
    }

    @Secured("isAuthenticated()")
    def update() {
        try {
            UpdateCustomerAdapter adapter = new UpdateCustomerAdapter(params)
            Customer customer = customerService.update(getCurrentCustomerId(), adapter)

            redirect(action: "show", id: customer.id)
        } catch (Exception exception) {
            log.error("CustomerController.update >> Não foi possível salvar as atualizações", exception)
            render "Não foi possível atualizar os dados"
        }
    }
}
