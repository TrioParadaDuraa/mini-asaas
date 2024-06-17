package com.mini.asaas.notification

import com.mini.asaas.BaseController

import grails.plugin.springsecurity.annotation.Secured
import grails.converters.JSON

@Secured("isAuthenticated()")
class NotificationController extends BaseController {

    NotificationService notificationService

    def list() {
        try {
            Long id = getCurrentCustomerId()
            def notifications = notificationService.list(id)
            throw new Exception("teste")

            respond notifications, formats: ['json']
        } catch (Exception exception) {
            log.error("NotificationController.list >> Erro tentando retornar notificações", exception)
            render([status: 500, error: "Internal Server Error"] as JSON)
        }
    }
}