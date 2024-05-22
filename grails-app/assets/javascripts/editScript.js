document.getElementById('edit-button').addEventListener('click', function () {
    let inputs = document.querySelectorAll('.update-input');
    inputs.forEach(function(input) {
        if (input.hasAttribute('readonly')){
            input.removeAttribute('readonly');
        }else {
            input.setAttribute('readonly', 'readonly')
        }
    });

    this.textContent = this.textContent === 'Habilitar edição' ? 'Desabilitar edição' : 'Habilitar edição';
});