package com.mini.asaas.utils.validators

class ValidatorCpfCnpj {

    static boolean isValidCpfCnpj(String cpfCnpj) {
        cpfCnpj = cpfCnpj.replaceAll("[^0-9]", "")
        
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
        if (cpf.matches("(\\d)\\1{10}")) {
            return false
        }

        int[] digits = cpf.collect { it as int - '0' as int }
        
        int sum = 0
        
        for (int i = 0; i < 9; i++) {
            sum += digits[i] * (10 - i)
        }
        
        int remainder = sum % 11
        int digit1 = (remainder < 2) ? 0 : (11 - remainder)
        
        sum = 0
        
        for (int i = 0; i < 10; i++) {
            sum += digits[i] * (11 - i)
        }
        
        remainder = sum % 11
        int digit2 = (remainder < 2) ? 0 : (11 - remainder)
        
        return digit1 == digits[9] && digit2 == digits[10]
    }

    private static boolean isValidCnpj(String cnpj) {
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false
        }

        int[] digits = cnpj.collect { it as int - '0' as int }
        
        int sum = 0
        
        int[] weights = [5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2]
        
        for (int i = 0; i < 12; i++) {
            sum += digits[i] * weights[i]
        }
        
        int remainder = sum % 11
        int digit1 = (remainder < 2) ? 0 : (11 - remainder)
        
        sum = 0
        weights = [6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2]
        
        for (int i = 0; i < 13; i++) {
            sum += digits[i] * weights[i]
        }
        
        remainder = sum % 11
        int digit2 = (remainder < 2) ? 0 : (11 - remainder)
        
        return digit1 == digits[12] && digit2 == digits[13]
    }
}
