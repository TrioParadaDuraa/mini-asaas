document.addEventListener('DOMContentLoaded', function() {
    setTimeout(function() {
        var errorMessage = document.querySelector('.error-message.has-errors');
        errorMessage.classList.remove('hide');

        setTimeout(function() {
            errorMessage.classList.add('hide');
        }, 7000);
    }, 300);
});
