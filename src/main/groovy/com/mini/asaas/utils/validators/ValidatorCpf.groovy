package com.mini.asaas.utils.validators

class CpfValidator {
    public static boolean isValidCpf(String cpf) {
        if (cpf.length() != 11) {
            return false
        }
        
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
}
