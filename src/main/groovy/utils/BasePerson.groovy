package com.mini.asaas.utils

import com.mini.asaas.utils.BaseDomain

abstract class BasePerson extends BaseDomain {

    String cpfOrCnpj
    String cep
    String endereco
    String cidade
    String estado

    static constraints = {
        cpfOrCnpj size: 11..14, blank: false, unique:true
        cep size: 8..8, blank: false
    }
}