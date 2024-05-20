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
            Customer customer = Customer.read(params.id)

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
            def customer = Customer.read(params.id)

            return [customer: customer]
        } catch (Exception exception){
            log.error("CustomerController.update >> Não foi possível realizar a edição", exception)
            flash.message = 'Não encontrado cliente para edição'
            def customer = Customer.read(params.id)

            render "Não foi possível editar, tente novamente"
        }
    }

    def sendUpdate() {
        try {
            customerService.update(params.long('id'), params)

            render"Atualização salva com sucesso"
        } catch (Exception exception){
            log.error("CustomerController.sendUpdate >> Não foi possivel salvar as atualizações", exception)
            flash.message = 'Não foi possivel atualizar os dados'
            def customer = Customer.read(params.id)

            redirect(action: "update", id: customer.id)
        }
    }
}