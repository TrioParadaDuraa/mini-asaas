package com.mini.asaas.utils

import grails.compiler.GrailsCompileStatic
import grails.util.Holders

import org.springframework.context.MessageSource

import java.text.DecimalFormat

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

    public static BigDecimal toBigDecimal(String value) {
        if (value == null || value.trim().isEmpty()) {
            return  null
        }

        try {
            value = value.replace(".", "")
            value = value.replace(',', '.')
            return new BigDecimal(value)
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("O valor fornecido não é um número válido: ${value}", exception)
        }
    }

    public static String removeNoNumeric(String value) {
        if (value == null) {
            return null
        }

        return value.replaceAll("[^0-9]", "")
    }
}
