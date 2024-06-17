function NotificationScriptController (reference) {
    var notificatioButtonReference = reference.querySelector('.js-notification-bell-button');
    var notificationDropDownReference = reference.querySelector('.js-notification-dropdown');
    var notificationContainerReference = notificationDropDownReference.querySelector('.js-notification-container');

    this.init = function () {
        bindNotification();
    }

    var bindNotification = function () {
        notificatioButtonReference.addEventListener("click", function () {
            fetch('/notifications')
                .then(response => response.json())
                .then(data => {
                    notificationContainerReference.innerHTML = '';

                    data.forEach(notification => {
                        var notificationLink = document.createElement('a');
                        var notificationCard = document.createElement('atlas-notification-card');

                        notificationCard.setAttribute('icon', 'alert-circle');
                        notificationCard.setAttribute('header', notification.title);
                        notificationCard.setAttribute('description', notification.description);

                        notificationLink.setAttribute('href', `/payment/show/${notification.payment.id}`);
                        notificationLink.appendChild(notificationCard);

                        notificationContainerReference.appendChild(notificationLink);
                    });
                })
                .catch(error => console.error('Erro ao carregar notificações:', error));
        });
    }
}

document.addEventListener("DOMContentLoaded", function () {
    var reference = document.querySelector('.js-navbar-user');
    var notificationScriptController = new NotificationScriptController(reference);
    notificationScriptController.init();
});