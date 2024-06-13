setTimeout(function() {
    var errorMessage = document.getElementById('error-message');
    errorMessage.classList.add('hide');
    setTimeout(function() {
        errorMessage.remove();
    }, 500);
}, 5000);