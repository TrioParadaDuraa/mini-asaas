package com.mini.asaas

import com.mini.asaas.user.Role

class BootStrap {

    def init = { servletContext ->
        createDefaultRole()
    }
    def destroy = {
    }

    private void createDefaultRole() {
        if (!Role.findByAuthority("ROLE_CUSTOMER")) {
            new Role(authority: "ROLE_CUSTOMER").save()
        }
    }
}
