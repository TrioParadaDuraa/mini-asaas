package com.mini.asaas.payer

class PayerController {

    def payerService

    def index() {}

    def save() {
        try {
            PayerAdapter adapter = new PayerAdapter(params)
            Payer payer = payerService.save(adapter)

            redirect(action: "show", id: payer.id)
        } catch (Exception e) {
            println(e)
            render "Não foi possível salvar"
        }
    }

    def show() {
        try{
            Payer payer = Payer.get(params.id)

            if (!payer) {
                render "Pagador não encontrado"
            }

            return [payer: payer]
        } catch (Exception e) {
            render "Pagador não encontrado"
        }
    }
}
