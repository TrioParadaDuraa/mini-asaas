package com.mini.asaas.user

import com.mini.asaas.BaseController

import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

@GrailsCompileStatic

class UserController extends BaseController {

    UserService userService

    def index() {}

    @Secured("isFullyAuthenticated()")
    def save() {
        try {
            UserAdapter adapter = new UserAdapter(params)
            User user = userService.saveCustomerUser(adapter, getCurrentCustomerId())

            redirect(action: "show", id: user.id)
        } catch (ValidationException validationException) {
            flash.errors = validationException.errors

            redirect(action: "index")
        } catch (Exception exception) {
            log.error("UserController.save >> Erro ao cadastrar usuário", exception)
            render "Não foi possível cadastrar o usuário"
        }
    }

    @Secured("isAuthenticated()")
    def edit() {
        try {
            User user = springSecurityService.currentUser as User

            return [user: user]
        } catch (Exception exception) {
            log.error("UserController.show >> Erro ao tentar apresentar dados de usuário", exception)
            render "Usuário não encontrado"
        }
    }
}
