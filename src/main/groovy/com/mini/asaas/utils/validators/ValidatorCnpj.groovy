package com.mini.asaas.utils.validators

class CnpjValidator {
    public static boolean isValidCnpj(String cnpj) {
        if (cnpj.length() != 14) {
            return false
        }
        
        if (cnpj.replaceAll("(.)\\1*", "").length() == 1) {
            return false
        }
        
        def sum = 0
        def weights = [5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2]
        (0..11).each { i ->
            sum += Integer.parseInt(cnpj[i]) * weights[i]
        }
        def digit1 = (sum % 11 < 2) ? 0 : (11 - sum % 11)
        
        if (digit1 != Integer.parseInt(cnpj[12])) {
            return false
        }
        
        sum = 0
        weights = [6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2]
        (0..12).each { i ->
            sum += Integer.parseInt(cnpj[i]) * weights[i]
        }
        def digit2 = (sum % 11 < 2) ? 0 : (11 - sum % 11)
        
        if (digit2 != Integer.parseInt(cnpj[13])) {
            return false
        }
        
        return true
    }
}
