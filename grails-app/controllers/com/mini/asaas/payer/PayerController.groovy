package com.mini.asaas.payer

import com.mini.asaas.customer.Customer

import grails.validation.ValidationException

class PayerController {

    def payerService

    def index() {}

    def save() {
        try {
            Long customerId = 1

            PayerAdapter adapter = new PayerAdapter(params)
            Payer payer = payerService.save(adapter, customerId)

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

            List<Payer> payers = payerService.findAllByCustomer(customerId)

            return [payers: payers]
        } catch (Exception exception) {
            log.error("PayerController.list >> Erro ao listar pagadores", exception)
            render "Não foi possível carregar pagadores"
        }
    }

    def edit() {
        try {
            Payer payer = Payer.read(params.long("id"))

            if (!payer) {
                throw new Exception("Pagador não encontrado")
            }

            return [payer: payer]
        } catch (Exception exception) {
            log.error("PayerController.edit >> Erro ao carregar pagador para edição", exception)
            render "Pagador não encontrado"
        }
    }

    def update() {
        try {
            Payer payer = Payer.get(params.long("id"))

            if (!payer) {
                throw new Exception("Pagador não encontrado")
            }

            PayerAdapter adapter = new PayerAdapter(params)
            payer = payerService.update(payer, adapter)

            redirect(action: "show", id: payer.id)
        } catch (ValidationException validationException) {
            flash.errors = validationException.errors
        
            redirect(action: "edit", id: params.id)
        } catch (Exception exception) {
            log.error("PayerController.update >> Erro ao atualizar dados de pagador", exception)
            render "Não foi possível atualizar dados do pagador"
        }
    }

    def delete() {
        try {
            Payer payer = Payer.get(params.long("id"))
            
            if (!payer) {
                throw new Exception("Pagador não encontrado")
            }

            payerService.delete(payer)

            redirect(action: "list")
        } catch (Exception exception) {
            log.error("PayerController.delete >> Erro ao excluir pagador", exception)
            render "Não foi possível excluir pagador"
        }
    }
}
