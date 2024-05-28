package com.mini.asaas.jobs

import com.mini.asaas.payment.Payment
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic

class DueDatePaymentJob {
    static triggers = {
      simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute() {
        // execute job
    }
}