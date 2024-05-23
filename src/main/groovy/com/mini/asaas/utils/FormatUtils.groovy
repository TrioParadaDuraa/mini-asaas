package com.mini.asaas.utils

import java.text.ParseException
import java.text.SimpleDateFormat

class FormatUtils {

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
