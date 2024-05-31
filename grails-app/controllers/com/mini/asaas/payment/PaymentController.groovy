package com.mini.asaas.payment

import com.mini.asaas.utils.message.MessageType

import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.annotation.Secured

@GrailsCompileStatic
@Secured("isAuthenticated()")
class PaymentController {

    PaymentService paymentService

    def index() {

    }

    def save() {
        try {
            PaymentAdapter adapter = new PaymentAdapter(params)
            Payment payment = paymentService.save(adapter)

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
            Long customerId = 1
            Long id = params.long('id')

            Payment payment = (Payment) Payment.query([customerId: customerId, id: id]).get()

            if (!payment) {
                throw new Exception("Cobrança não encontrada")
            }

            return [payment: payment]
        } catch (Exception exception) {
            log.error("PaymentController.show >> Erro ao exibir cobrança", exception)
            render "Cobrança não encontrada"
        }
    }

    def update() {
        try {
            Long customerId = 1
            Long id = params.long('id')

            Payment payment = (Payment) Payment.query([customerId: customerId, id: id]).get()

            if (!payment) {
                throw new Exception("Cobrança não encontrada")
            } else if (payment.deleted) {
                throw new Exception("Cobrança inativa")
            }

            PaymentAdapter adapter = new PaymentAdapter(params)
            paymentService.update(payment, adapter)

            redirect(action: "show", id: payment.id)
        } catch (Exception exception) {
            log.error("PaymentController.update >> Erro ao atualizar dados da cobrança", exception)
            render "Não foi possivel fazer a atualização dos dados de cobrança"
        }
    }

    def delete() {
        try {
            Long customerId = 1
            Long id = params.long('id')

            Payment payment = (Payment) Payment.query([customerId: customerId, id: id]).get()

            if (!payment) {
                throw new Exception("Cobrança não encontrada")
            } else if (payment.deleted) {
                throw new Exception("Cobrança já inativa")
            }

            paymentService.delete(payment)

            redirect(action: "show", id: payment.id)
        } catch (Exception exception) {
            log.error("PaymentController.delete >> Erro ao excluir cobrança", exception)
            render "Não foi possível excluir a cobrança"
        }
    }

    def restore() {
        try {
            Long customerId = 1
            Long id = params.long('id')

            Payment payment = (Payment) Payment.query([customerId: customerId, id: id]).get()

            if (!payment) {
                throw new Exception("Cobrança não encontrada")
            } else if (!payment.deleted) {
                throw new Exception("Cobrança não inativa")
            }

            paymentService.restore(payment)

            redirect(action: "show", id: payment.id)
        } catch (Exception exception) {
            log.error("PaymentController.restore >> Erro ao restaurar cobrança", exception)
            render "Não foi possivel restaurar a cobrança"
        }
    }
}
