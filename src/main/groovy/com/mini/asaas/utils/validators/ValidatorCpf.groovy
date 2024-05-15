package com.mini.asaas.utils.validators

class CpfValidator {

    public static boolean isValidCpf(String cpf) {
        if (cpf.length() != 11) {
            return false
        }

        if (cpf.replaceAll("(.)\\1*", "").length() == 1) {
            return false
        }
      
        return true
    }
}
