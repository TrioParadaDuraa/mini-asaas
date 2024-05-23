package com.mini.asaas.customer

import com.mini.asaas.utils.message.MessageType

class CustomerController {
    
    CustomerService customerService

    def index() {

    }

    def save() {
        try {
            CustomerAdapter adapter = new CustomerAdapter(params)
            Customer customer = customerService.save(adapter)

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

    def update() {
        try {
            CustomerAdapter adapter = new CustomerAdapter(params)
            customerService.update(params.long('id'), adapter)

            redirect(action: "show", id: params.long('id'))
        } catch (Exception exception) {
            log.error("CustomerController.update >> Não foi possivel salvar as atualizações", exception)
            render "Não foi possível atualizar os dados"
        }
    }
}