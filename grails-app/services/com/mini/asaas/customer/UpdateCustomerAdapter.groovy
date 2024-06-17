package com.mini.asaas.customer

import com.mini.asaas.domain.base.BasePersonAdapter
import com.mini.asaas.utils.Utils

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class UpdateCustomerAdapter extends BasePersonAdapter {

    public UpdateCustomerAdapter(Map params){
        this.name = params.name.toString().trim()
        this.email = params.email
        this.phone = Utils.removeNoNumeric(params.phone.toString()) ?: null
        this.mobilePhone = Utils.removeNoNumeric(params.mobilePhone.toString())
        this.postalCode = Utils.removeNoNumeric(params.postalCode.toString())
        this.address = params.address.toString().trim()
        this.addressNumber = params.addressNumber.toString().trim() ?: "S/N"
        this.addressComplement = params.addressComplement.toString().trim() ?: null
        this.district = params.district.toString().trim()
        this.city = params.city.toString().trim()
        this.state = params.state.toString().trim()
    }
}
