package com.mini.asaas.domain.base

import com.mini.asaas.utils.base.PersonType
import com.mini.asaas.utils.validators.CpfCnpjValidator
import com.mini.asaas.utils.validators.MobilePhoneValidator
import com.mini.asaas.utils.validators.PostalCodeValidator

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
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
        cpfCnpj size: 11..14, blank: false, validator: { String cpfCnpj ->
            return CpfCnpjValidator.isValidCpfCnpj(cpfCnpj)
        }

        name blank: false
        email email: true, blank: false
        phone blank: false, nullable: true, size: 10..10
        mobilePhone blank: false, size: 11..11, validator: { String mobilePhone ->
            return MobilePhoneValidator.isValidMobilePhone(mobilePhone)
        }

        personType blank: false, validator: { PersonType personType, BasePerson person ->
            if (personType == PersonType.NATURAL) {
                return CpfCnpjValidator.isValidCpf(person.cpfCnpj)
            } else if (personType == PersonType.LEGAL) {
                return CpfCnpjValidator.isValidCnpj(person.cpfCnpj)
            }

            return false
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
