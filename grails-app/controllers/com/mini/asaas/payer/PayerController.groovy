package com.mini.asaas.payer

import com.mini.asaas.customer.Customer
import com.mini.asaas.utils.Utils

import grails.validation.ValidationException

class PayerController {

    PayerService payerService

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

            redirect(action: "index")
        } catch (Exception exception) {
            log.error("PayerController.save >> Erro ao cadastrar pagador", exception)
            render "Não foi possível salvar"
        }
    }

    def show() {
        try{
            Long customerId = 1
            Long id = params.long("id")

            Payer payer = Payer.query([customerId: customerId, id: id]).get()

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
        List allowedFilters = ["deleted"]

        try {
            Long customerId = 1

            Map filterList = Utils.getFilterListFromParams(params, allowedFilters)

            if (!filterList.containsKey("deleted")) {
                filterList.deleted = false
            }

            List<Payer> payerList = payerService.list(customerId, filterList)

            return [payerList: payerList]
        } catch (Exception exception) {
            log.error("PayerController.list >> Erro ao listar pagadores", exception)
            render "Não foi possível carregar pagadores"
        }
    }

    def update() {
        try {
            Long customerId = 1
            Long id = params.long("id")

            Payer payer = Payer.query([customerId: customerId, id: id, deleted: false]).get()

            if (!payer) {
                throw new Exception("Pagador não encontrado")
            } else if (payer.deleted) {
                throw new Exception("Pagador está inativo")
            }

            PayerAdapter adapter = new PayerAdapter(params)
            payer = payerService.update(payer, adapter)

            redirect(action: "show", id: payer.id)
        } catch (ValidationException validationException) {
            flash.errors = validationException.errors
        
            redirect(action: "show", id: params.id)
        } catch (Exception exception) {
            log.error("PayerController.update >> Erro ao atualizar dados de pagador", exception)
            render "Não foi possível atualizar dados do pagador"
        }
    }

    def delete() {
        try {
            Long customerId = 1
            Long id = params.long("id")

            Payer payer = Payer.query([customerId: customerId, id: id, deleted: false]).get()
            
            if (!payer) {
                throw new Exception("Pagador não encontrado")
            } else if (payer.deleted) {
                throw new Exception("Pagador já está inativo")
            }

            payerService.delete(payer)

            redirect(action: "list")
        } catch (Exception exception) {
            log.error("PayerController.delete >> Erro ao excluir pagador", exception)
            render "Não foi possível excluir pagador"
        }
    }

    def restore() {
        try {
            Long customerId = 1
            Long id = params.long("id")

            Payer payer = Payer.query([customerId: customerId, id: id, deleted: true]).get()

            if (!payer) {
                throw new Exception("Pagador não encontrado")
            } else if (!payer.deleted) {
                throw new Exception("Pagador não está inativo")
            }

            payerService.restore(payer)

            redirect(action: "list")
        } catch (Exception exception) {
            log.error("PayerController.restore >> Erro ao restaurar pagador", exception)
            render "Não foi possível restaurar pagador"
        }
    }
}
