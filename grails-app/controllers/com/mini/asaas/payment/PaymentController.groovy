package com.mini.asaas.payment

import com.mini.asaas.BaseController
import com.mini.asaas.payer.Payer
import com.mini.asaas.payer.PayerService

import com.mini.asaas.utils.Utils
import com.mini.asaas.utils.message.MessageType

import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.annotation.Secured

@GrailsCompileStatic
@Secured("isAuthenticated()")
class PaymentController extends BaseController {

    PaymentService paymentService

    PayerService payerService

    def index() {
        List<Payer> payerList = payerService.list([:], getCurrentCustomerId())

        return [payerList: payerList]
    }

    def save() {
        try {
            PaymentAdapter adapter = new PaymentAdapter(params)
            Payment payment = paymentService.save(adapter, getCurrentCustomerId())

            redirect (action: "show", id: payment.id)
        } catch (Exception exception) {
            log.error("PaymentController.save >> Erro ao cadastrar cobrança", exception)
            flash.type = MessageType.ERROR
            flash.message = 'Erro ao salvar os dados de sua cobrança, verifique todos os campos e tente novamente.'

            redirect (action: "index")
        }
    }

    def show() {
        try {
            Payment payment = paymentService.find(params.long('id'), getCurrentCustomerId())

            return [payment: payment]
        } catch (Exception exception) {
            log.error("PaymentController.show >> Erro ao exibir cobrança", exception)
            render "Cobrança não encontrada"
        }
    }

    def update() {
        try {
            Long id = params.long('id')

            Payment payment = (Payment) Payment.query([customerId: getCurrentCustomerId(), id: id]).get()

            if (!payment) {
                throw new Exception("Cobrança não encontrada")
            } else if (payment.deleted) {
                throw new Exception("Cobrança inativa")
            }

            PaymentAdapter adapter = new PaymentAdapter(params)
            paymentService.update(payment.id, adapter)

            redirect(action: "show", id: payment.id)
        } catch (Exception exception) {
            log.error("PaymentController.update >> Erro ao atualizar dados da cobrança", exception)
            render "Não foi possivel fazer a atualização dos dados de cobrança"
        }
    }

    def delete() {
        try {
            Long id = params.long('id')

            Payment payment = (Payment) Payment.query([customerId: getCurrentCustomerId(), id: id]).get()

            if (!payment) {
                throw new Exception("Cobrança não encontrada")
            } else if (payment.deleted) {
                throw new Exception("Cobrança já inativa")
            }

            paymentService.delete(payment.id)

            redirect(action: "show", id: payment.id)
        } catch (Exception exception) {
            log.error("PaymentController.delete >> Erro ao excluir cobrança", exception)
            render "Não foi possível excluir a cobrança"
        }
    }

    def restore() {
        try {
            Long id = params.long('id')

            Payment payment = (Payment) Payment.query([customerId: getCurrentCustomerId(), id: id]).get()

            if (!payment) {
                throw new Exception("Cobrança não encontrada")
            } else if (!payment.deleted) {
                throw new Exception("Cobrança não inativa")
            }

            paymentService.restore(payment.id)

            redirect(action: "show", id: payment.id)
        } catch (Exception exception) {
            log.error("PaymentController.restore >> Erro ao restaurar cobrança", exception)
            render "Não foi possivel restaurar a cobrança"
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

            List<Payment> paymentList = Payment.query(filterList).list() as List<Payment>

            return [paymentList: paymentList]
        } catch (Exception exception) {
            log.error("PaymentController.list >> Erro ao listar cobranças", exception)
            render "Não foi possível carregar cobranças"
        }
    }
}
