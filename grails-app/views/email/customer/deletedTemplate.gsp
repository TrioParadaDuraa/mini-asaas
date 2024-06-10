<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <asset:stylesheet src="template.css"/>
    </head>
    <body>
        <div class="images">
            <asset:image src="/assets/images/loginpage/asaas-text.svg"/>
        </div>
        <div class="message">
            <h2>Cobrança deletada! ❌</h2>
            <p>Olá, 👋</p>
            <p>Uma cobrança foi cancelada e excluída.</p>
            <p>Por favor, verifique os detalhes em sua conta.</p>
        </div>
            <a class="button-homepage" href="${createLink(controller: 'payment', action: 'list')}">Acessar minhas cobranças</a>
    </body>
</html>
