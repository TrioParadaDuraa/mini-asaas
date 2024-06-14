<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="main">
        <meta charset="UTF-8">
        <title>Bem-vindo ao Mini Asaas</title>
    </head>
    <body>
        <div class="dashboard-title">
            <h1>Boas vindas novamente! 😉 </h1>
        </div>
        <div class="dashboard-cards-box">
            <g:render template="templates/indexCards/cardPagadores"/>
            <g:render template="templates/indexCards/cardCobrancas"/>
            <g:render template="templates/indexCards/cardFaturamento"/>
        </div>
    </body>
</html>