package com.mini.asaas.dashboard

import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.annotation.Secured

@GrailsCompileStatic
class DashboardController {

    @Secured("isAuthenticated()")
    def index() {

    }
}
