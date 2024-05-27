package com.mini.asaas.domain.base

import com.mini.asaas.utils.base.PersonType
import com.mini.asaas.utils.validators.CpfCnpjValidator
import com.mini.asaas.utils.validators.MobilePhoneValidator
import com.mini.asaas.utils.validators.PostalCodeValidator

abstract class BasePerson extends BaseDomain {

    String cpfCnpj

    String name

    String email

    String phone

    String mobilePhone

    PersonType personType

    String postalCode

    String address

    String addressNumber

    String addressComplement

    String district

    String city

    String state

    static constraints = {
        cpfCnpj size: 11..14, blank: false, validator: { String cpfCnpj, def person ->
            if (person.PersonType == PersonType.NATURAL) {
                return CpfCnpjValidator.isValidCpf(cpfCnpj)
            } else if (person.PersonType == PersonType.LEGAL) {
                return CpfCnpjValidator.isValidCnpj(cpfCnpj)
            }

            return false
        }
        name blank: false
        email email: true, blank: false
        phone blank: false, nullable: true, size: 10..10
        mobilePhone blank: false, size: 11..11, validator: { String mobilePhone ->
            return MobilePhoneValidator.isValidMobilePhone(mobilePhone)
        }
        postalCode blank: false, size: 8..8, validator: { String postalCode ->
            return PostalCodeValidator.isValidPostalCode(postalCode)
        }
        address blank: false
        addressNumber blank: false
        addressComplement blank: false, nullable: true
        district blank: false
        city blank: false
        state blank: false, size: 2..2
    }
}
