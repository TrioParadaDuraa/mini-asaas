package com.mini.asaas.payer

import com.mini.asaas.utils.base.PersonType

class PayerController {

    def payerService

    def index() {
        return [personTypes: PersonType.values()]
    }

    def save() {
        try {
            Long customerId = 1

            PayerAdapter adapter = new PayerAdapter(params)
            Payer payer = payerService.save(adapter, customerId)

            redirect(action: "show", id: payer.id)
        } catch (Exception exception) {
            log.error("PayerController.save >> Erro ao cadastrar pagador", exception)

            render "Não foi possível salvar"
        }
    }

    def show() {
        try{
            Payer payer = Payer.read(params.id)

            if (!payer) {
                render "Pagador não encontrado"
            }

            return [payer: payer]
        } catch (Exception exception) {
            render "Pagador não encontrado"
        }
    }
}
