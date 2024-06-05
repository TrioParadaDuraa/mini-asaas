<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="external">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>Login</title>
        <asset:stylesheet src="loginpage.css"/>
    </head>
    <body>
        <atlas-page>
            <atlas-page-content slot="content" class="js-atlas-content">
                <div class="login">
                    <div class="images">
                        <asset:image src="/loginpage/asaas-text.svg" class="asaas-text"/><br>
                        <asset:image src="/loginpage/girl-laptop.svg" class="girl-laptop"/>
                    </div>
                    <div class="inner">
                        <div class="fheader">Acesse sua conta! ✅</div>
                        <atlas-form action="${createLink(controller: 'login', action: 'authenticate')}">
                            <atlas-col lg="4" md="2" sm="1">
                                <atlas-masked-input class="email-label" mask-alias="email" label="Email" required="" size="md" placeholder="email@dominio.com" name="email" value="${params.email}"></atlas-masked-input>
                            </atlas-col>
                            <atlas-col lg="6" md="3" sm="1">
                                <atlas-password-input class="password-label" label="Senha" required="" name="password" size="md"></atlas-password-input>
                            </atlas-col>
                            <div class="button">
                                <atlas-button submit description="Entrar" slot="actions" theme="success"></atlas-button><br>
                            </div>
                        </atlas-form>
                        <div class="bottom-text">
                            <a class="button-homepage" href="${createLink(controller: 'customer', action: 'index')}">Ainda não possui uma conta?</a>
                        </div>
                    </div>
                </div>
            </atlas-page-content>
        </atlas-page>
    </body>
</html>
