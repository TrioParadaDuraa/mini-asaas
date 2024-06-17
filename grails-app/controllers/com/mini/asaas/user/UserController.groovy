package com.mini.asaas.user

import com.mini.asaas.BaseController
import com.mini.asaas.utils.message.MessageType

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
            CreateUserAdapter adapter = new CreateUserAdapter(params)
            User user = userService.saveCustomerUser(adapter, getCurrentCustomerId())

            redirect(action: "list")
        } catch (ValidationException validationException) {
            flash.type = MessageType.ERROR
            flash.errors = validationException.errors.allErrors

            redirect(action: "index")
        } catch (Exception exception) {
            log.error("UserController.save >> Erro ao cadastrar usuário", exception)
            render "Não foi possível cadastrar o usuário"
        }
    }

    def list() {
        try {
            List<User> userList = userService.list(getCurrentCustomerId())
            
            return [userList: userList]
        } catch (Exception exception) {
            log.error("UserController.list >> Erro ao listar usuários", exception)
            render "Não foi possível carregar usuários"
        }
    }

    def edit() {
        try {
            User user = getCurrentUser()

            return [user: user]
        } catch (Exception exception) {
            log.error("UserController.show >> Erro ao tentar apresentar dados de usuário", exception)
            render "Usuário não encontrado"
        }
    }

    @Secured("isFullyAuthenticated()")
    def updatePassword() {
        try {
            UpdateUserPasswordAdapter adapter = new UpdateUserPasswordAdapter(params)
            userService.updatePassword(getCurrentUser().id, adapter)

            redirect(controller: "customer", action: "show")
        } catch (ValidationException validationException) {
            flash.type = MessageType.ERROR
            flash.errors = validationException.errors.allErrors

            redirect(action: "edit")
        } catch (Exception exception) {
            log.error("UserController.updatePassword >> Erro ao atualizar senha de usuário", exception)
            render "Não foi possível atualizar senha de usuário"
        }
    }
}
