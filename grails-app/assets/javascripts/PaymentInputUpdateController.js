function PaymentInputUpdateController(reference) {
    var payerCpfCnpj = reference.querySelector('.js-payer-cpf-cnpj');
    var payerEmail = reference.querySelector('.js-payer-email');
    var payerMobilePhone = reference.querySelector('.js-payer-mobile-phone');
    var payerSelect = reference.querySelector('.js-payer-select');
    var selectReference = reference.querySelector("atlas-select");
    var selectedOptions;

    this.init = function() {
        bindSelect();
    }

    var bindSelect = function () {
        payerSelect.addEventListener("atlas-select-change", function() {
            selectedOptions = selectReference.getSelectedOptions();

            payerCpfCnpj.value = selectedOptions.customProperties.customCpfcnpj
            payerEmail.value = selectedOptions.customProperties.customEmail
            payerMobilePhone.value = selectedOptions.customProperties.customMobilephone
        });
    }
}

document.addEventListener("DOMContentLoaded", function () {
    var reference = document.querySelector('.js-payment-panel')
    var paymentInputUpdateController = new PaymentInputUpdateController(reference);
    paymentInputUpdateController.init();
});