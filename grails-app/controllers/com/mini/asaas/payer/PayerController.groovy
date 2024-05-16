package com.mini.asaas.payer

class PayerController {

    def payerService

    def index() {}

    def save() {
        try {
            // Modificar para usar id do customer associado ao usuário logado
            // ex.: Long customerId = currentUser.customer.id
            Long customerId = 1

            PayerAdapter adapter = new PayerAdapter(params)
            Payer payer = payerService.save(adapter, customerId)

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
