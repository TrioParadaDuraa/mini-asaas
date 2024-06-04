package com.mini.asaas.customer

import com.mini.asaas.domain.base.BasePersonAdapter
import com.mini.asaas.utils.Utils

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class UpdateCustomerAdapter extends BasePersonAdapter {

    public UpdateCustomerAdapter(Map params){
        this.name = params.name
        this.email = params.email
        this.phone = Utils.removeNoNumeric(params.phone.toString())
        this.mobilePhone = Utils.removeNoNumeric(params.mobilePhone.toString())
        this.postalCode = Utils.removeNoNumeric(params.postalCode.toString())
        this.address = params.address
        this.addressNumber = params.addressNumber
        this.addressComplement = (params.addressComplement.toString().trim()) ? params.addressComplement : null
        this.district = params.district
        this.city = params.city
        this.state = params.state
    }
}
