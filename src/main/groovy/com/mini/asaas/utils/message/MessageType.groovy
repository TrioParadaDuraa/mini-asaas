package com.mini.asaas.utils.message

enum MessageType {

    SUCCESS,
    ERROR,
    WARNING

    String toLowerCase() {
        return this.name().toLowerCase()
    }
}