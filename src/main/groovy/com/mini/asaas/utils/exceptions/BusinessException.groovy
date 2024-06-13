package com.mini.asaas.utils.exceptions

class BusinessException extends RuntimeException{

    BusinessException(String message) {
        super(message)
    }

    BusinessException(String message, Throwable cause) {
        super(message, cause)
    }
}
