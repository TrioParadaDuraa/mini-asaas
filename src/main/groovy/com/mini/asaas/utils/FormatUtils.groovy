package com.mini.asaas.utils

import java.text.ParseException
import java.text.SimpleDateFormat

class FormatUtils {

    public static final DATE_FORMAT = "dd/MM/yyyy"

    public static Date toDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            return null
        }

        SimpleDateFormat inputSdf = new SimpleDateFormat(FormatUtils.DATE_FORMAT)

        try {
            return inputSdf.parse(date)
        } catch (ParseException exception) {
            throw new IllegalArgumentException("A data fornecida não é válida: ${date}", exception)
        }
    }

    public static String formatDateToString(Date date) {
        if (date == null) {
            return null
        }

        SimpleDateFormat outputSdf = new SimpleDateFormat(FormatUtils.DATE_FORMAT)

        return outputSdf.format(date)
    }
}
