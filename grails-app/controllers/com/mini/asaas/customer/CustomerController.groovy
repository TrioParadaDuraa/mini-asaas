package com.mini.asaas.customer

import com.mini.asaas.user.UserAdapter
import com.mini.asaas.utils.message.MessageType

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class CustomerController {
    
    CustomerService customerService

    def index() {}

    def save() {
        try {
            CustomerAdapter customerAdapter = new CustomerAdapter(params)
            UserAdapter userAdapter = new UserAdapter(params)

            Customer customer = customerService.save(customerAdapter, userAdapter)

            redirect(action: "show", id: customer.id)
        } catch (Exception exception) {
            log.error("CustomerController.save >> Erro ao cadastrar cliente", exception)
            flash.type = MessageType.ERROR
            flash.message = 'Erro ao salvar os dados, verifique todos os campos e tente novamente.'

            redirect(action: "index")
        }
    }

    def show() {
        try {
            Customer customer = Customer.read(params.long('id'))

            if (!customer) {
                throw new Exception("Cliente não encontrado")
            }

            return [customer: customer]
        } catch (Exception exception) {
            log.error("CustomerController.show >> Cliente não encontrado", exception)
            render "Cliente não encontrado"
        }
    }

    def edit() {
        try {
            Customer customer = Customer.read(params.long('id'))

            if (!customer) {
                throw new Exception("Cliente não encontrado para edição")
            }

            return [customer: customer]
        } catch (Exception exception) {
            log.error("CustomerController.edit >> Cliente não encontrado para edição", exception)
            render "Cliente não encontrado para edição"
        }
    }

    def update() {
        try {
            Long customerId = params.long('id')

            CustomerAdapter adapter = new CustomerAdapter(params)
            customerService.update(customerId, adapter)

            redirect(action: "show", id: customerId)
        } catch (Exception exception) {
            log.error("CustomerController.update >> Não foi possivel salvar as atualizações", exception)
            render "Não foi possível atualizar os dados"
        }
    }
}