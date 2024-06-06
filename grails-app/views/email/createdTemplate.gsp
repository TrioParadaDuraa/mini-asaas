<%@ page import="com.mini.asaas.payer.Payer; com.mini.asaas.payment.Payment"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <asset:stylesheet src="template.css"/>
    </head>

    <body>
    <div class="images">
        <asset:image src="/loginpage/asaas-text.svg"/>
    </div>
    <div class="message">
    <h2>Cobrança Criada</h2>
    <p>Olá,</p>
    <p>Uma nova cobrança no valor de R$... foi criada.</p>
    <p>Por favor, verifique os detalhes em sua conta.</p>
        <div>
    <div class="button">
        <atlas-button type="filled" size="md" theme="primary" href="/localhost:8080/" description="Acessar minha conta"></atlas-button>
    </div>
    </body>
</html>
