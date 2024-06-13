package com.mini.asaas.customer

import com.mini.asaas.user.CreateUserAdapter
import com.mini.asaas.user.UserService

import com.mini.asaas.domain.base.BasePersonAdapter
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

    UserService userService

    public Customer save(CreateCustomerAdapter customerAdapter, CreateUserAdapter userAdapter) {
        Customer customer = validateSave(customerAdapter)

        if (customer.hasErrors()) throw new ValidationException("Erro ao salvar conta", customer.errors)

        buildCustomerPropertiesForSave(customer, customerAdapter)

        customer.save(failOnError: true)
        userService.saveCustomerUser(userAdapter, customer.id)

        return customer
    }

    public Customer update(Long customerId, UpdateCustomerAdapter adapter) {
        Customer customer = validate(adapter)

        if (customer.hasErrors()) throw new ValidationException("Erro ao atualizar conta", customer.errors)

        customer = Customer.get(customerId)

        buildCustomerProperties(customer, adapter)

        customer.save(failOnError: true)

        return customer
    }

    private void buildCustomerProperties(Customer customer, BasePersonAdapter adapter) {
        customer.name = adapter.name
        customer.email = adapter.email
        customer.phone = adapter.phone
        customer.mobilePhone = adapter.mobilePhone
        customer.postalCode = adapter.postalCode
        customer.address = adapter.address
        customer.addressNumber = adapter.addressNumber
        customer.addressComplement = adapter.addressComplement
        customer.district = adapter.district
        customer.city = adapter.city
        customer.state = adapter.state
    }

    private void buildCustomerPropertiesForSave(Customer customer, CreateCustomerAdapter adapter) {
        buildCustomerProperties(customer, adapter)
        customer.cpfCnpj = adapter.cpfCnpj
        customer.personType = adapter.personType
    }

    private Customer validate(BasePersonAdapter adapter) {
        Customer customer = new Customer()

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

    private Customer validateSave(CreateCustomerAdapter adapter) {
        Customer customer = validate(adapter)

        if (Customer.findByCpfCnpj(adapter.cpfCnpj)) {
            customer.errors.reject("cpfCnpj", null, "CPF/CNPJ já cadastrado")
        }

        if (!CpfCnpjValidator.isValidCpfCnpj(adapter.cpfCnpj)) {
            customer.errors.reject("cpfCnpj", null, "CPF/CNPJ inválido")
        }

        if (CpfCnpjValidator.isValidCpf(adapter.cpfCnpj) && adapter.personType != PersonType.NATURAL) {
            customer.errors.reject("personType", null, "Tipo de pessoa não condiz com campo CPF/CNPJ")
        } else if (CpfCnpjValidator.isValidCnpj(adapter.cpfCnpj) && adapter.personType != PersonType.LEGAL) {
            customer.errors.reject("personType", null, "Tipo de pessoa não condiz com campo CPF/CNPJ")
        }

        return customer
    }
}
