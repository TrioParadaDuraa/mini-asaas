package com.mini.asaas.payer

import com.mini.asaas.BaseController
import com.mini.asaas.customer.Customer
import com.mini.asaas.utils.Utils

import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

@GrailsCompileStatic
@Secured("isAuthenticated()")
class PayerController extends BaseController {

    PayerService payerService

    def index() {}

    def save() {
        try {
            PayerAdapter adapter = new PayerAdapter(params)
            Payer payer = payerService.save(adapter, getCurrentCustomerId())

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
            Long id = params.long("id")

            Payer payer = (Payer) Payer.query([customerId: getCurrentCustomerId(), id: id]).get()

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
            Map filterList = Utils.getFilterListFromParams(params, allowedFilters)
            filterList.put("cutomerId", getCurrentCustomerId())

            if (!filterList.containsKey("deleted")) {
                filterList.deleted = false
            }

            List<Payer> payerList = (List<Payer>) Payer.query(filterList).list()

            return [payerList: payerList]
        } catch (Exception exception) {
            log.error("PayerController.list >> Erro ao listar pagadores", exception)
            render "Não foi possível carregar pagadores"
        }
    }

    def edit() {
        try {
            Long id = params.long("id")

            Payer payer = (Payer) Payer.query([customerId: getCurrentCustomerId(), id: id]).get()

            if (!payer) {
                throw new Exception("Pagador não encontrado")
            }

            return [payer: payer]
        } catch (Exception exception) {
            log.error("PayerController.edit >> Erro ao tentar editar pagador", exception)
            render "Não foi possível editar pagador"
        }
    }

    def update() {
        try {
            Long id = params.long("id")

            Payer payer = (Payer) Payer.query([customerId: getCurrentCustomerId(), id: id]).get()

            if (!payer) {
                throw new Exception("Pagador não encontrado")
            } else if (payer.deleted) {
                throw new Exception("Pagador está inativo")
            }

            PayerAdapter adapter = new PayerAdapter(params)
            payer = payerService.update(payer.id, adapter)

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
            Long id = params.long("id")

            Payer payer = (Payer) Payer.query([customerId: getCurrentCustomerId(), id: id]).get()
            
            if (!payer) {
                throw new Exception("Pagador não encontrado")
            } else if (payer.deleted) {
                throw new Exception("Pagador já está inativo")
            }

            payerService.delete(payer.id)

            redirect(action: "list")
        } catch (Exception exception) {
            log.error("PayerController.delete >> Erro ao excluir pagador", exception)
            render "Não foi possível excluir pagador"
        }
    }

    def restore() {
        try {
            Long id = params.long("id")

            Payer payer = (Payer) Payer.query([customerId: getCurrentCustomerId(), id: id]).get()

            if (!payer) {
                throw new Exception("Pagador não encontrado")
            } else if (!payer.deleted) {
                throw new Exception("Pagador não está inativo")
            }

            payerService.restore(payer.id)

            redirect(action: "list")
        } catch (Exception exception) {
            log.error("PayerController.restore >> Erro ao restaurar pagador", exception)
            render "Não foi possível restaurar pagador"
        }
    }
}
