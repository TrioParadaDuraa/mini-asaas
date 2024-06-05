console.log('batata')

function ListFilterController () {
    var filterReference = document.getElementById('js-payment-filter')
    var tableReference = document.getElementById('js-payment-table')


    this.init = function () {
        bindFilterStatus();
        bindFilterActivation();
    }

    function bindFilterStatus() {
        filterReference.addEventListener("atlas-apply-filter", function () {
            tableReference.fetchRecords(true);
        });

        filterReference.addEventListener("atlas-clean-filter", function () {
            tableReference.fetchRecords(true);
        });
    }

    function fetchRecords() {

    }

    function bindFilterActivation() {
        filterReference.enableButtons();
    }
}

document.addEventListener("DOMContentLoaded", function () {
    var listFilterController = new ListFilterController();
    listFilterController.init();
});