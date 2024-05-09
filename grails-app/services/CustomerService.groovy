package com.mini.asaas

import com.mini.asaas.Customer
import com.mini.asaas.PersonType
import grails.gorm.transactions.Transactional

@Transactional
class CustomerService {
    public Customer save(String name, String email, String cpfOrCnpj, String cep, String endereco, String cidade, String estado){
        Customer customer = new Customer()
        customer.name = name
        customer.email = email
        customer.personType = PersonType.NATURAL // valor deve ser definido de acordo com cpf/cnpj
        customer.cpfOrCnpj = cpfOrCnpj
        customer.cep = cep
        customer.endereco = endereco
        customer.cidade = cidade
        customer.estado = estado
        customer.save(failOnError: true)
        return customer
    }
}