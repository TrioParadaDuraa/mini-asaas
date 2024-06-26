package com.mini.asaas

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "index", action: "index")
        "500"(view:'/error')
        "404"(view:'/notFound')
        "/notifications"(controller: 'notification', action: 'list')
    }
}
