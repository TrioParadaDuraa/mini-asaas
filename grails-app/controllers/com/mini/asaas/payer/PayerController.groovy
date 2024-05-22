package com.mini.asaas.payer

import com.mini.asaas.customer.Customer

import grails.validation.ValidationException

class PayerController {

    def payerService

    def index() {}

    def save() {
        try {
            Long customerId = 1
            Customer customer = Customer.read(customerId)

            PayerAdapter adapter = new PayerAdapter(params)
            Payer payer = payerService.save(adapter, customer)

            redirect(action: "show", id: payer.id)
        } catch (ValidationException validationException) {
            flash.errors = validationException.errors

            log.error(validationException)
            
            redirect(action: "index")
        } catch (Exception exception) {
            log.error("PayerController.save >> Erro ao cadastrar pagador", exception)
            render "Não foi possível salvar"
        }
    }

    def show() {
        try{
            Payer payer = Payer.read(params.id)

            if (!payer) {
                throw new Exception("Pagador não encontrado")
            }

            return [payer: payer]
        } catch (Exception exception) {
            log.error("PayerController.show >> Erro ao tentar apresentar dados de pagador", exception)
            render "Pagador não encontrado"
        }
    }

    def list() {
        try {
            Long customerId = 1
            Customer customer = Customer.read(customerId)

            List<Payer> payers = payerService.list(customer)

            return [payers: payers]
        } catch (Exception exception) {
            log.error("PayerController.list >> Erro ao listar pagadores", exception)
            render "Não foi possível carregar pagadores"
        }
    }
}
