package com.mini.asaas.user

import grails.validation.ValidationException

class UserController {

    UserService userService

    def index() {}

    def save() {
        try {
            Long customerId = 1
            
            UserAdapter adapter = new UserAdapter(params)
            
            User user = userService.save(adapter, customerId)

            redirect(action: "show", id: user.id)
        } catch (Exception exception) {
            log.error("UserController.save >> Erro ao cadastrar usuário", exception)
            render "Não foi possível cadastrar o usuário"
        }
    }

    def show() {
        try {
            User user = User.read(params.long("id"))

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
