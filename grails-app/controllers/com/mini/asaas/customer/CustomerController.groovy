package com.mini.asaas.customer

import com.mini.asaas.BaseController

import com.mini.asaas.user.CreateUserAdapter

import com.mini.asaas.utils.message.MessageType

import com.mini.asaas.domain.exceptions.BusinessException

import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

@GrailsCompileStatic
class CustomerController extends BaseController {
    
    CustomerService customerService

    @Secured("permitAll")
    def index() {
        if (isLoggedIn()) {
            redirect(controller: "dashboard", action: "index")
        }
    }

    @Secured("permitAll")
    def save() {
        if (isLoggedIn()) {
            return redirect(controller: "dashboard", action: "index")
        }

        try {
            CreateCustomerAdapter customerAdapter = new CreateCustomerAdapter(params)
            CreateUserAdapter userAdapter = new CreateUserAdapter(params)

            Customer customer = customerService.save(customerAdapter, userAdapter)

            redirect(controller: "login", action: "auth")
        } catch (ValidationException validationException) {
            flash.type = MessageType.ERROR
            flash.errors = validationException.errors.allErrors
            flash.oldFormData = params
            
            redirect(action: "index")
        } catch (BusinessException exception) {
            log.error("CustomerController.save >> Erro ao cadastrar cliente", exception)
            flash.type = MessageType.ERROR
            flash.message = "Ocorreu um erro ao salvar os dados."

            redirect(action: "index")
        }
    }

    @Secured("isAuthenticated()")
    def show() {
        try {
            Customer customer = Customer.read(getCurrentCustomerId())

            if (!customer) throw new BusinessException("Cliente não encontrado")

            return [customer: customer]
        } catch (BusinessException exception) {
            log.error("CustomerController.show >> Cliente não encontrado", exception)
            render view: /error/
        }
    }

    @Secured("isAuthenticated()")
    def edit() {
        try {
            Customer customer = Customer.read(getCurrentCustomerId())

            if (!customer) throw new BusinessException("Cliente não encontrado para edição")

            return [customer: customer]
        } catch (BusinessException exception) {
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
        } catch (ValidationException validationException) {
            flash.type = MessageType.ERROR
            flash.errors = validationException.errors.allErrors
            
            redirect(action: "edit")
        } catch (BusinessException exception) {
            log.error("CustomerController.update >> Não foi possível salvar as atualizações", exception)

            flash.type = MessageType.ERROR
            flash.message = "Não foi possível atualizar os dados"
            redirect(action: "edit")
        }
    }
}
