package com.mini.asaas.customer

class CustomerController {
    
    def customerService

    def index() {

    }

    def save() {
        try {
            CustomerAdapter adapter = new CustomerAdapter(params)
            Customer customer = customerService.save(adapter)

            redirect(action: "show", id: customer.id)
        } catch (Exception exception) {
            log.error("CustomerController.save >> Erro ao cadastrar cliente", exception)
            flash.message = 'Erro ao salvar os dados, verifique todos os campos e tente novamente.'

            redirect(action: "index")
         }
    }

    def show() {
        try {
            Customer customer = Customer.read(params.id)
            if (!customer) {
                render "Cliente não encontrado"
            }

            return [customer: customer]
       } catch (Exception exception) {
            log.error("CustomerController.show >> Cliente não encontrado", exception)
           render "Cliente não encontrado"
        }
    }
}