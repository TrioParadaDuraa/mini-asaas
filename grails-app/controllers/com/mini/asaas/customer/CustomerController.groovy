package com.mini.asaas.customer

import com.mini.asaas.utils.message.MessageType

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class CustomerController {
    
    CustomerService customerService

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