
import com.mini.asaas.Customer
import utils.CustomerAdapter
import grails.gorm.transactions.Transactional

@Transactional
class CustomerService {
    public Customer save(CustomerAdapter adapter){
        Customer customer = new Customer()

        customer.cpfCnpj = adapter.cpfCnpj
        customer.name = adapter.name
        customer.email = adapter.email
        customer.postalCode = adapter.postalCode
        customer.address = adapter.address
        customer.city = adapter.city
        customer.state = adapter.state
        customer.personType = adapter.personType

        customer.save(failOnError: true)
        return customer
    }
}