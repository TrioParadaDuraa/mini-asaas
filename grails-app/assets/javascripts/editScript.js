document.getElementById('edit-button').addEventListener('click', function () {
    let inputs = document.querySelectorAll('.js-update-input');
    let originalValues = {};
    let saveButton = document.getElementById('save-button');

    inputs.forEach(function(input) {
        if (input.hasAttribute('readonly')){
            input.removeAttribute('readonly');
        } else {
            input.setAttribute('readonly', 'readonly')
        }
    });

    inputs.forEach(function (input) {
        originalValues[input.name] = input.value;
        input.addEventListener('input', function () {
            let hasChanges = false;
            inputs.forEach(function (input) {
                if (input.value !== originalValues[input.name]) {
                    hasChanges = true;
                }
            });
            if (hasChanges) {
                saveButton.classList.remove('hidden');
                saveButton.classList.add('visible');
            } else {
                saveButton.classList.remove('visible');
                saveButton.classList.add('hidden');
            }
        });
    });
    this.textContent = this.textContent === 'Habilitar edição' ? 'Desabilitar edição' : 'Habilitar edição';
});