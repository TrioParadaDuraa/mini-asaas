package com.mini.asaas.utils

import grails.compiler.GrailsCompileStatic
import grails.util.Holders

import org.springframework.context.MessageSource

@GrailsCompileStatic
class Utils {

    public static String getMessageProperty(String messageCode, List arguments) {
        MessageSource messageSource = (MessageSource) Holders.applicationContext.getBean("messageSource")

        return messageSource.getMessage(messageCode, arguments as Object[],"", new Locale("pt","BR"))
    }

    public static Map getFilterListFromParams(Map params, List allowedFilters) {
        Map filterList = params
        
        filterList.retainAll{it -> it.key in allowedFilters}

        return filterList
    }
}
