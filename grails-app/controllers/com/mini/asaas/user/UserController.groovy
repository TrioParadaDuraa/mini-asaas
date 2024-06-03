package com.mini.asaas.user

import com.mini.asaas.BaseController

import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

@GrailsCompileStatic
@Secured("isAuthenticated()")
class UserController extends BaseController {

    UserService userService

    def index() {}

    @Secured("isFullyAuthenticated()")
    def save() {
        try {
            Long customerId = getCurrentUser().customer.id
            
            UserAdapter adapter = new UserAdapter(params)
            User user = userService.saveCustomerUser(adapter, customerId)

            redirect(action: "show", id: user.id)
        } catch (ValidationException validationException) {
            flash.errors = validationException.errors

            redirect(action: "index")
        } catch (Exception exception) {
            log.error("UserController.save >> Erro ao cadastrar usuário", exception)
            render "Não foi possível cadastrar o usuário"
        }
    }

    def show() {
        try {
            Long customerId = getCurrentUser().customer.id
            Long id = params.long("id")

            User user = (User) User.query([customerId: customerId, id: id]).get()

            if (!user) {
                throw new Exception("Usuário não encontrado")
            }

            return [user: user]
        } catch (Exception exception) {
            log.error("UserController.show >> Erro ao tentar apresentar dados de usuário", exception)
            render "Usuário não encontrado"
        }
    }
}
