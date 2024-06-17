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
        user.name = adapter.name

        user.save(failOnError: true)

        Role role = Role.findByAuthority("ROLE_CUSTOMER")
        UserRole.create(user, role)

        return user
    }

    public List<User> list(Long customerId) {
        return User.query([customerId: customerId]).list() as List<User>
    }

    public void updatePassword(Long userId, UpdateUserPasswordAdapter adapter) {
        User validUser = validatePassword(adapter)

        if (validUser.hasErrors()) throw new ValidationException("Erro nos campos de usuário", validUser.errors)

        User user = User.get(userId)

        user.password = adapter.password
        user.passwordConfirm = adapter.passwordConfirm

        user.save(failOnError: true)
    }

    private User validateSave(CreateUserAdapter adapter) {
        User user = validatePassword(adapter)

        if (!EmailValidator.isValidEmail(adapter.username)) {
            user.errors.reject("username", null, "Email inválido")
        }

        if (!adapter.name) {
            user.errors.reject("name", null, "Nome inválido")
        }

        return user
    }

    private User validatePassword(BaseUserAdapter adapter) {
        User user = new User()

        if (!PasswordValidator.matches(adapter.password, adapter.passwordConfirm)) {
            user.errors.reject("password", null, "Confirmação de senha incorreta")
        } else if (!PasswordValidator.isStrong(adapter.password)) {
            user.errors.reject("password", null, "A senha não atende aos requisitos mínimos")
        }

        return user
    }
}
