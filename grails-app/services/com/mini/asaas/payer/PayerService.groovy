package com.mini.asaas.payer

import com.mini.asaas.customer.Customer

import com.mini.asaas.utils.base.PersonType
import com.mini.asaas.utils.validators.CpfCnpjValidator
import com.mini.asaas.utils.validators.EmailValidator
import com.mini.asaas.utils.validators.MobilePhoneValidator
import com.mini.asaas.utils.validators.PhoneValidator
import com.mini.asaas.utils.validators.PostalCodeValidator

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException

@GrailsCompileStatic
@Transactional
class PayerService {

    public Payer save(PayerAdapter adapter, Long customerId) {
        Payer payer = validate(adapter)

        if (payer.hasErrors()) throw new ValidationException("Erro ao salvar payer", payer.errors)

        buildPayerProperties(payer, adapter)
        payer.customer = Customer.read(customerId)

        payer.save(failOnError: true)
        
        return payer
    }

    public Payer find(Long payerId, Long customerId) {
        Payer payer = Payer.query([customerId: customerId, id: payerId]).get() as Payer

        if (!payer) throw new RuntimeException("Pagador não encontrado")

        return payer
    }

    public List<Payer> list(Map filterList, Long customerId) {
        if (!filterList.containsKey("deleted")) {
            filterList.deleted = false
        }
        filterList.put("customerId", customerId)

        List<Payer> payerList = Payer.query(filterList).list() as List<Payer>
    }

    public void update(Long payerId, Long customerId, PayerAdapter adapter) {
        Payer payer = find(payerId, customerId)

        if (payer.deleted) throw new RuntimeException("Pagador está inativo")

        Payer validPayer = validate(adapter)

        if (validPayer.hasErrors()) throw new ValidationException("Erro ao salvar payer", validPayer.errors)

        buildPayerProperties(payer, adapter)

        payer.save(failOnError: true)
    }

    public void delete(Long payerId, Long customerId) {
        Payer payer = find(payerId, customerId)

        if (payer.deleted) throw new RuntimeException("Pagador já está inativo")

        payer.deleted = true

        payer.save(failOnError: true)
    }

    public void restore(Long payerId, Long customerId) {
        Payer payer = find(payerId, customerId)

        if (!payer.deleted) throw new RuntimeException("Pagador não está inativo")
        
        payer.deleted = false

        payer.save(failOnError: true)
    }

    private void buildPayerProperties(Payer payer, PayerAdapter adapter) {
        payer.cpfCnpj = adapter.cpfCnpj
        payer.name = adapter.name
        payer.email = adapter.email
        payer.phone = adapter.phone
        payer.mobilePhone = adapter.mobilePhone
        payer.personType = adapter.personType
        payer.postalCode = adapter.postalCode
        payer.address = adapter.address
        payer.addressNumber = adapter.addressNumber
        payer.addressComplement = adapter.addressComplement
        payer.district = adapter.district
        payer.city = adapter.city
        payer.state = adapter.state
    }

    private Payer validate(PayerAdapter adapter) {
        Payer payer = new Payer()

        if (!CpfCnpjValidator.isValidCpfCnpj(adapter.cpfCnpj)) {
            payer.errors.reject("cpfCnpj", null, "CPF/CNPJ inválido")
        }

        if (!adapter.name) {
            payer.errors.reject("name", null, "Nome inválido")
        }

        if (!EmailValidator.isValidEmail(adapter.email)) {
            payer.errors.reject("email", null, "Email inválido")
        }

        if (adapter.phone && !PhoneValidator.isValidPhone(adapter.phone)) {
            payer.errors.reject("phone", null, "Telefone inválido")
        }

        if (!MobilePhoneValidator.isValidMobilePhone(adapter.mobilePhone)) {
            payer.errors.reject("mobilePhone", null, "Número de celular inválido")
        }

        if (CpfCnpjValidator.isValidCpf(adapter.cpfCnpj) && adapter.personType != PersonType.NATURAL) {
            payer.errors.reject("personType", null, "Tipo de pessoa não condiz com campo CPF/CNPJ")
        } else if (CpfCnpjValidator.isValidCnpj(adapter.cpfCnpj) && adapter.personType != PersonType.LEGAL) {
            payer.errors.reject("personType", null, "Tipo de pessoa não condiz com campo CPF/CNPJ")
        }

        if (!PostalCodeValidator.isValidPostalCode(adapter.postalCode)) {
            payer.errors.reject("postalCode", null, "CEP inválido")
        }

        if (!adapter.address) {
            payer.errors.reject("address", null, "Endereço inválido")
        }

        if (adapter.addressNumber != "S/N" && !adapter.addressNumber.matches("[0-9]+")) {
            payer.errors.reject("addressNumber", null, "Número inválido")
        }

        if (!adapter.district) {
            payer.errors.reject("district", null, "Bairro inválido")
        }

        if (!adapter.city) {
            payer.errors.reject("city", null, "Cidade inválida")
        }

        if (!adapter.state) {
            payer.errors.reject("state", null, "UF inválida")
        }

        return payer
    }
}
