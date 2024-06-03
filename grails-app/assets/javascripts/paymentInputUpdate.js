function PaymentInputUpdateController() {
    var payerSelect = document.getElementById('js-payer-select');

    this.init = function() {
        bindSelect();
    }

    var bindSelect = function () {
        payerSelect.addEventListener("atlas-select-change", function() {
            document.querySelector("atlas-select").selectedOptions;
        });
    }

}

document.addEventListener("DOMContentLoaded", function () {
    var paymentInputUpdateController = new PaymentInputUpdateController();
    paymentInputUpdateController.init();
})