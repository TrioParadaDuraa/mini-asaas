package com.mini.asaas.utils

import grails.util.Holders

import java.text.ParseException
import java.text.SimpleDateFormat

class Utils {

    public static String getMessageProperty(String messageCode, List arguments) {
        return Holders.applicationContext.getBean("messageSource").getMessage(messageCode, arguments as Object[],"", new Locale("pt","BR"))
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

    public static Date toDate(String date, String inputFormat = "yyyy-MM-dd") {
        if (date == null || date.trim().isEmpty()) {
            return null
        }

        SimpleDateFormat inputSdf = new SimpleDateFormat(inputFormat)

        try {
            return inputSdf.parse(date)
        } catch (ParseException exception) {
            throw new IllegalArgumentException("A data fornecida não é válida: ${date}", exception)
        }
    }

    public static String formatDateToString(Date date, String outputFormat = "dd/MM/yyyy") {
        if (date == null) {
            return null
        }
        SimpleDateFormat outputSdf = new SimpleDateFormat(outputFormat)
        return  outputSdf.format(date)
    }
}
