package com.mini.asaas

import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.annotation.Secured

@GrailsCompileStatic
@Secured("permitAll")
class IndexController {

    def index() {
        if (isLoggedIn()) {
            return redirect(controller: "dashboard", action: "index")
        }

        render(view: "/index")
    }
}
