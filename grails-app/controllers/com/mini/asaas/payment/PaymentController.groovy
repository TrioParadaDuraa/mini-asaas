package com.mini.asaas.payment

import com.mini.asaas.utils.message.MessageType

class PaymentController {

    PaymentService paymentService

    def index() {

    }

    def save() {
        try {
            PaymentAdapter adapter = new PaymentAdapter(params)
            Payment payment = paymentService.save(adapter)

            render "Cobrança criada com sucesso"
        } catch (Exception exception) {
            log.error("PaymentController.save >> Erro ao cadastrar cobrança", exception)
            flash.type = MessageType.ERROR
            flash.message = 'Erro ao salvar os dados de sua cobrança, verifique todos os campos e tente novamente.'

            redirect (action: "index")
        }
    }

    def show() {

    }

    def update() {

    }

    def delete() {

    }
}
