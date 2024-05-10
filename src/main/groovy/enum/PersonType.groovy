package com.mini.asaas

import grails.util.Holders

enum PersonType {
    NATURAL,
    LEGAL

    public static PersonType convert(String personType){
            try {
                if (personType instanceof String) personType = personType.toUpperCase()
                return personType as PersonType
            } catch(Exception e) {
                return null
            }
    }

    public String getLabel() {
        return Holders.applicationContext.getBean("messageSource").getMessage("PersonType.${this}.label", null, "", new Locale("pt", "BR"))
    }
}