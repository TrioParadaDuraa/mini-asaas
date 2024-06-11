package com.mini.asaas.user

import com.mini.asaas.customer.Customer

import com.mini.asaas.utils.validators.EmailValidator
import com.mini.asaas.utils.validators.PasswordValidator

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException

@GrailsCompileStatic
@Transactional
class UserService {

    public User saveCustomerUser(CreateUserAdapter adapter, Long customerId) {
        User validUser = validateSave(adapter)

        if (validUser.hasErrors()) throw new ValidationException("Erro nos campos de usuário", validUser.errors)

        User user = new User()
        user.customer = Customer.read(customerId)
        user.username = adapter.username
        user.password = adapter.password
        user.passwordConfirm = adapter.passwordConfirm

        user.save(failOnError: true)

        Role role = Role.findByAuthority("ROLE_CUSTOMER")
        UserRole.create(user, role)

        return user
    }

    private User validateSave(CreateUserAdapter adapter) {
        User user = new User()

        if (!EmailValidator.isValidEmail(adapter.username)) {
            user.errors.reject("username", null, "Email inválido")
        }

        if (!PasswordValidator.matches(adapter.password, adapter.passwordConfirm)) {
            user.errors.reject("password", null, "Confirmação de senha incorreta")
        } else if (!PasswordValidator.isStrong(adapter.password)) {
            user.errors.reject("password", null, "A senha não atende aos requisitos mínimos")
        }

        return user
    }
}
