function PaymentInputUpdateController() {
    var payerCpfCnpj = document.getElementById('js-payer-cpf-cnpj');
    var payerEmail = document.getElementById('js-payer-email');
    var payerMobilePhone = document.getElementById('js-payer-mobile-phone');
    var payerSelect = document.getElementById('js-payer-select');
    var selectReference = document.querySelector("atlas-select");
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
    var paymentInputUpdateController = new PaymentInputUpdateController();
    paymentInputUpdateController.init();
})