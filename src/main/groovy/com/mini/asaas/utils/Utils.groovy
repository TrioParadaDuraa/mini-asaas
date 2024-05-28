package com.mini.asaas.utils

import grails.compiler.GrailsCompileStatic
import grails.util.Holders

@GrailsCompileStatic
class Utils {

    public static String getMessageProperty(String messageCode, List arguments) {
        return Holders.applicationContext.getBean("messageSource").getMessage(messageCode, arguments as Object[],"", new Locale("pt","BR"))
    }
}
