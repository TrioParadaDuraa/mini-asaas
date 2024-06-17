package com.mini.asaas.payer

import com.mini.asaas.BaseController
import com.mini.asaas.customer.Customer

import com.mini.asaas.utils.Utils
import com.mini.asaas.utils.message.MessageType

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
            flash.type = MessageType.ERROR
            flash.errors = validationException.errors.allErrors

            redirect(action: "index")
        } catch (Exception exception) {
            log.error("PayerController.save >> Erro ao cadastrar pagador", exception)
            render "Não foi possível salvar"
        }
    }

    def show() {
        try{
            Payer payer = payerService.find([id: params.long("id"), customerId: getCurrentCustomerId()])

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
            filterList.customerId = getCurrentCustomerId()

            List<Payer> payerList = payerService.list(filterList)

            return [payerList: payerList]
        } catch (Exception exception) {
            log.error("PayerController.list >> Erro ao listar pagadores", exception)
            render "Não foi possível carregar pagadores"
        }
    }

    def edit() {
        try {
            Payer payer = payerService.find([id: params.long("id"), customerId: getCurrentCustomerId()])

            return [payer: payer]
        } catch (Exception exception) {
            log.error("PayerController.edit >> Erro ao tentar editar pagador", exception)
            render "Não foi possível editar pagador"
        }
    }

    def update() {
        try {
            PayerAdapter adapter = new PayerAdapter(params)
            payerService.update(params.long("id"), getCurrentCustomerId(), adapter)

            redirect(action: "show", id: params.id)
        } catch (ValidationException validationException) {
            flash.type = MessageType.ERROR
            flash.errors = validationException.errors.allErrors
        
            redirect(action: "edit", id: params.id)
        } catch (Exception exception) {
            log.error("PayerController.update >> Erro ao atualizar dados de pagador", exception)
            render "Não foi possível atualizar dados do pagador"
        }
    }

    def delete() {
        try {
            payerService.delete(params.long("id"), getCurrentCustomerId())

            redirect(action: "list")
        } catch (Exception exception) {
            log.error("PayerController.delete >> Erro ao excluir pagador", exception)
            render "Não foi possível excluir pagador"
        }
    }

    def restore() {
        try {
            payerService.restore(params.long("id"), getCurrentCustomerId())

            redirect(action: "list")
        } catch (Exception exception) {
            log.error("PayerController.restore >> Erro ao restaurar pagador", exception)
            render "Não foi possível restaurar pagador"
        }
    }
}
