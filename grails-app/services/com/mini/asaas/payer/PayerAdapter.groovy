package com.mini.asaas.payer

import com.mini.asaas.domain.base.BasePersonAdapter
import com.mini.asaas.utils.base.PersonType

class PayerAdapter extends BasePersonAdapter {

    public PayerAdapter(Map params) {
        this.cpfCnpj = params.cpfCnpj
        this.name = params.name
        this.email = params.email
        this.phone = params.phone
        this.personType = PersonType.NATURAL
        this.postalCode = params.postalCode
        this.address = params.address
        this.addressNumber = params.addressNumber
        this.addressComplement = params.addressComplement
        this.district = params.district
        this.city = params.city
        this.state = params.state
    }
}
