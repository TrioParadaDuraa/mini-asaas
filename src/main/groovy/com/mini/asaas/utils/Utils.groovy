package com.mini.asaas.utils

import grails.util.Holders

class Utils {

    public static String getMessageProperty(String messageCode, List arguments) {
        return Holders.applicationContext.getBean("messageSource").getMessage(messageCode, arguments as Object[],"", new Locale("pt","BR"))
    }

    public static Map getFilterListFromParams(Map params) {
        Map filterList = params.clone()
        filterList.remove("controller")
        filterList.remove("action")

        return filterList
    }
}
