package com.mini.asaas.payer

import com.mini.asaas.domain.base.BasePersonAdapter
import com.mini.asaas.utils.base.PersonType

class PayerAdapter extends BasePersonAdapter {

    Long customerId

    public PayerAdapter(Map params) {
        this.cpfCnpj = params.cpfCnpj
        this.name = params.name
        this.email = params.email
        this.postalCode = params.postalCode
        this.address = params.address
        this.city = params.city
        this.state = params.state
        this.personType = PersonType.NATURAL
        this.customerId = params.long("customerId")
    }
}
