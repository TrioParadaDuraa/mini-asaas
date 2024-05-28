package com.mini.asaas.utils

import java.text.ParseException
import java.text.SimpleDateFormat

class FormatUtils {

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

        return outputSdf.format(date)
    }
}
