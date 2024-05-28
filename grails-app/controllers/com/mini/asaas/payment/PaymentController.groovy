package com.mini.asaas.payment

import com.mini.asaas.utils.message.MessageType

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
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
            Long payerId = 1
            Long id = params.long('id')

            Payment payment = (Payment) Payment.query([customerId: customerId, payerId: payerId, id: id]).get()

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

    }
}
