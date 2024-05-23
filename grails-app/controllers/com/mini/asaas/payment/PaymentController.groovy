package com.mini.asaas.payment

import com.mini.asaas.payer.Payer
import com.mini.asaas.utils.message.MessageType

class PaymentController {

    PaymentService paymentService

    def index() {

    }

    def save() {
        try {
            Long customerId = 1
            Long payerId = 1

            PaymentAdapter adapter = new PaymentAdapter(params)
            Payment payment = paymentService.save(adapter, payerId, customerId)

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
            Payment payment = Payment.read(params.long('id'))

            if (!payment) {
                throw new Exception("Cobrança não encontrada")
            }

            return [payment: payment]
        } catch (Exception exception) {
            log.error("PaymentController.show >> Erro ao exibir cobrança", exception)
            render "Cobrança não encontrada"
        }
    }
}