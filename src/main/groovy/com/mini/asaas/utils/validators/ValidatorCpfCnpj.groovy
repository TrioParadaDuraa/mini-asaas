package com.mini.asaas.utils.validators

class ValidatorCpfCnpj {

    static boolean isValidCpfCnpj(String cpfCnpj) {
        if (!cpfCnpj.matches("\\d{11}") && !cpfCnpj.matches("\\d{14}")) {
            return false
        }
    
        if (cpfCnpj.length() == 11) {
            return isValidCpf(cpfCnpj)
        } else if (cpfCnpj.length() == 14) {
            return isValidCnpj(cpfCnpj)
        } else {
            return false
        }
    }

    private static boolean isValidCpf(String cpf) {
        if (cpf.replaceAll("(.)\\1*", "").length() == 1) {
            return false
        }

        def sum = 0
        (0..8).each { i ->
            sum += Integer.parseInt(cpf[i]) * (10 - i)
        }
        
        def digit1 = (sum * 10) % 11
        
        if (digit1 == 10) digit1 = 0

        if (digit1 != Integer.parseInt(cpf[9])) {
            return false
        }

        sum = 0
        (0..9).each { i ->
            sum += Integer.parseInt(cpf[i]) * (11 - i)
        }
        
        def digit2 = (sum * 10) % 11
        
        if (digit2 == 10) digit2 = 0

        if (digit2 != Integer.parseInt(cpf[10])) {
            return false
        }

        return true
    }

    private static boolean isValidCnpj(String cnpj) {
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
