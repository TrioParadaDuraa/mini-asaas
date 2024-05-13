package utils

import com.mini.asaas.Customer
import com.mini.asaas.PersonType

class CustomerAdapter {

    String cpfCnpj
    String name
    String email
    String postalCode
    String address
    String city
    String state
    PersonType personType


    public CustomerAdapter(Map params){
        this.cpfCnpj = params.cpfCnpj
        this.name = params.name
        this.email = params.email
        this.postalCode = params.postalCode
        this.address = params.address
        this.city = params.city
        this.state = params.state
        this.personType = PersonType.NATURAL
    }

}