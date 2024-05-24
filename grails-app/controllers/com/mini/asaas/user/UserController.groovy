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

            redirect(action: "index")
        } catch (Exception exception) {
            log.error("UserController.save >> Erro ao cadastrar usuário", exception)
            render "Não foi possível cadastrar o usuário"
        }
    }
}
