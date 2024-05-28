package com.mini.asaas.utils

import grails.compiler.GrailsCompileStatic
import grails.util.Holders

@GrailsCompileStatic
class Utils {

    public static String getMessageProperty(String messageCode, List arguments) {
        return Holders.applicationContext.getBean("messageSource").getMessage(messageCode, arguments as Object[],"", new Locale("pt","BR"))
    }

    public static Map getFilterListFromParams(Map params, List allowedFilters) {
        Map filterList = params.clone()

        filterList.retainAll{it -> it.key in allowedFilters}

        return filterList
    }

    public static BigDecimal toBigDecimal(String value) {
        if (value == null || value.trim().isEmpty()) {
            return  null
        }

        try {
            return new BigDecimal(value.replace(',', '.'))
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("O valor fornecido não é um número válido: ${value}", exception)
        }
    }
}
