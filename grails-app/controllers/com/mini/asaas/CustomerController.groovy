
package com.mini.asaas

import com.mini.asaas.Customer

class CustomerController {
    
    def CustomerService

    def index () {

    }

    def save() {
        try {
            String name = params.name
            String email = params.email
            String cpfOrCnpj = params.cpfOrCnpj
            String cep = params.cep
            String endereco = params.endereco
            String cidade = params.cidade
            String estado = params.estado
            Customer customer = customerService.save(name, email, cpfOrCnpj, cep, endereco, cidade, estado)
            redirect(action: "show", id: customer.id)
        } catch (Exception e) {
            println(e)
            render "Não foi possível salvar"
        }
}

    def show() {
        try {
            Customer customer = Customer.get(params.id)
            if (!customer) {
                render "Cliente não encontrado"
            }
                return [customer: customer]
       } catch (Exception e) {
           render "Cliente não encontrado"
       }

    }

}