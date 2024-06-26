<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Mini Asaas</title>
    <asset:stylesheet src="homepage.css"/>
    <asset:link rel="icon" href="asaas-icon.png" type="image/x-icon"/>
</head>
<body>
    <div class="page-container">
        <div class="left-bar">
            <asset:image src="/homepage/asaas-logo.png" class="asaas-logo"/>
            <asset:image src="/homepage/cell-phone.png" class="cellphone"/>
        </div>
        <div class="center">
            <div class="top-text">
                <h1>Pensou em controle de recebíveis?<br>Pensou em mini-Asaas! 🪽</h1>
            </div>
            <div class="card-buttons">
                <a class="button-homepage" href="${createLink(controller: 'login', action: 'auth')}">Acessar conta</a>
                <br>
                <a class="button-homepage" href="${createLink(controller: 'customer', action: 'index')}">Criar conta</a>
            </div>
            <footer class="bottom-text">
                <a href="https://ajuda.asaas.com/pt-BR/articles/102021-termos-e-condicoes-de-uso">Termos de uso</a>
                <a href="https://ajuda.asaas.com/pt-BR/articles/102029-politica-de-privacidade">Politicas de Privacidade</a>
            </footer>
        </div>
        <div class="right-bar">
            <asset:image src="/homepage/blue-detail.png" class="blue-detail"/>
            <asset:image src="/homepage/asaas-paper.png" class="asaas-paper"/>
            <asset:image src="/homepage/asaas-girl.png" class="asaas-girl"/>
        </div>
    </div>
</body>
</html>