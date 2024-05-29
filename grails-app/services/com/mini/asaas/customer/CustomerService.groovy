package com.mini.asaas.customer

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
class CustomerService {

    public Customer save(CustomerAdapter adapter) {
        Customer customer = validateSave(adapter)

        if (customer.hasErrors()) {
            throw new ValidationException("Erro ao salvar conta", customer.errors)
        }

        buildCustomerProperties(customer, adapter)

        customer.save(failOnError: true)

        return customer
    }

    public update(Long customerId, CustomerAdapter adapter) {
        Customer customer = Customer.get(customerId)

        buildCustomerProperties(customer, adapter)

        customer.save(failOnError: true)
    }

    private buildCustomerProperties(Customer customer, CustomerAdapter adapter) {
        customer.cpfCnpj = adapter.cpfCnpj
        customer.name = adapter.name
        customer.email = adapter.email
        customer.phone = adapter.phone
        customer.mobilePhone = adapter.mobilePhone
        customer.personType = adapter.personType
        customer.postalCode = adapter.postalCode
        customer.address = adapter.address
        customer.addressNumber = adapter.addressNumber
        customer.addressComplement = adapter.addressComplement
        customer.district = adapter.district
        customer.city = adapter.city
        customer.state = adapter.state
    }

    private Customer validateSave(CustomerAdapter adapter) {
        Customer customer = new Customer()

        if (!CpfCnpjValidator.isValidCpfCnpj(adapter.cpfCnpj)) {
            customer.errors.reject("cpfCnpj", null, "CPF/CNPJ inválido")
        }

        if (!adapter.name) {
            customer.errors.reject("name", null, "Nome inválido")
        }

        if (!EmailValidator.isValidEmail(adapter.email)) {
            customer.errors.reject("email", null, "Email inválido")
        }

        if (adapter.phone && !PhoneValidator.isValidPhone(adapter.phone)) {
            customer.errors.reject("phone", null, "Telefone inválido")
        }

        if (!MobilePhoneValidator.isValidMobilePhone(adapter.mobilePhone)) {
            customer.errors.reject("mobilePhone", null, "Número de celular inválido")
        }

        if (
            CpfCnpjValidator.isValidCpf(adapter.cpfCnpj) && adapter.personType != PersonType.NATURAL ||
            CpfCnpjValidator.isValidCnpj(adapter.cpfCnpj) && adapter.personType != PersonType.LEGAL
        ) {
            customer.errors.reject("personType", null, "Tipo de pessoa não condiz com campo CPF/CNPJ")
        }

        if (!PostalCodeValidator.isValidPostalCode(adapter.postalCode)) {
            customer.errors.reject("postalCode", null, "CEP inválido")
        }

        if (!adapter.address) {
            customer.errors.reject("address", null, "Endereço inválido")
        }

        if (adapter.addressNumber != "S/N" && !adapter.addressNumber.matches("[0-9]+")) {
            customer.errors.reject("addressNumber", null, "Número inválido")
        }

        if (!adapter.district) {
            customer.errors.reject("district", null, "Bairro inválido")
        }

        if (!adapter.city) {
            customer.errors.reject("city", null, "Cidade inválida")
        }

        if (!adapter.state) {
            customer.errors.reject("state", null, "UF inválida")
        }

        return customer
    }
}