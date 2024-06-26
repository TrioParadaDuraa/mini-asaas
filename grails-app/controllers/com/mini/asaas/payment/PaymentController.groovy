package com.mini.asaas.payment

import com.mini.asaas.BaseController
import com.mini.asaas.payer.Payer
import com.mini.asaas.payer.PayerService

import com.mini.asaas.utils.Utils
import com.mini.asaas.utils.enums.PaymentStatus
import com.mini.asaas.utils.message.MessageType

import com.mini.asaas.domain.exceptions.BusinessException

import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

@GrailsCompileStatic
@Secured("isAuthenticated()")
class PaymentController extends BaseController {

    PaymentService paymentService

    PayerService payerService

    def index() {
        List<Payer> payerList = payerService.list([customerId: getCurrentCustomerId()])

        return [payerList: payerList]
    }

    def save() {
        try {
            PaymentAdapter adapter = new PaymentAdapter(params)
            Payment payment = paymentService.save(adapter, getCurrentCustomerId())

            redirect (action: "show", id: payment.id)
        } catch (ValidationException validationException) {
            flash.type = MessageType.ERROR
            flash.errors = validationException.errors.allErrors
            
            redirect(action: "index")
        } catch (Exception exception) {
            log.error("PaymentController.save >> Erro ao cadastrar cobrança", exception)
            flash.type = MessageType.ERROR
            flash.message = 'Erro ao salvar os dados de sua cobrança, verifique todos os campos e tente novamente.'

            redirect (action: "index")
        }
    }

    def show() {
        try {
            Payment payment = paymentService.find([id: params.long('id'), customerId: getCurrentCustomerId()])

            return [payment: payment]
        } catch (BusinessException exception) {
            log.error("PaymentController.show >> Erro ao exibir cobrança", exception)
            render view: /error/
        }
    }

    def updateStatus() {
        try {
            PaymentStatus status = PaymentStatus.convert(params.status)
            paymentService.updateStatus(params.long('id'), status)

            redirect(action: "show", id: params.id)
        } catch (BusinessException exception) {
            log.error("PaymentController.update >> Erro ao atualizar status", exception)
            flash.type = MessageType.ERROR
            flash.message = 'Erro ao atualizar status, tente novamente.'
            redirect(action: "show", id: params.id)
        }
    }

    def delete() {
        try {
            paymentService.delete(params.long('id'), getCurrentCustomerId())

            redirect(action: "show", id: params.id)
        } catch (BusinessException exception) {
            log.error("PaymentController.delete >> Erro ao excluir cobrança", exception)
            render "Não foi possível excluir a cobrança"
        }
    }

    def restore() {
        try {
            paymentService.restore(params.long('id'), getCurrentCustomerId())

            redirect(action: "show", id: params.id)
        } catch (BusinessException exception) {
            log.error("PaymentController.restore >> Erro ao restaurar cobrança", exception)
            render "Não foi possivel restaurar a cobrança"
        }
    }

    def list() {
        List allowedFilters = ["deleted"]

        try {
            Map filterList = Utils.getFilterListFromParams(params, allowedFilters)
            filterList.customerId = getCurrentCustomerId()
            
            List<Payment> paymentList = paymentService.list(filterList)

            return [paymentList: paymentList]
        } catch (BusinessException exception) {
            log.error("PaymentController.list >> Erro ao listar cobranças", exception)
            render "Não foi possível carregar cobranças"
        }
    }

    def proof() {
        try {
            Payment payment = paymentService.find([id: params.long('id'), customerId: getCurrentCustomerId()])

            return [payment: payment]
        } catch (BusinessException exception) {
            log.error("PaymentController.proof >> Erro ao gerar comprovante de cobrança", exception)
            render "Não foi possível gerar seu comprovante de cobrança"
        }
    }
}
