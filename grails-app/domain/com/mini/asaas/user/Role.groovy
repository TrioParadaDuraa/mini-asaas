package com.mini.asaas.user

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Role implements Serializable {

	private static final long serialVersionUID = 1

    String authority

    static constraints = {
        authority nullable: false, blank: false
    }

    static mapping = {
        cache true
        authority unique: true
    }
}
