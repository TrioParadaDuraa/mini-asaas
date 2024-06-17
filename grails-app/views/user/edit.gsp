<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta name="layout" content="main">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alterar senha</title>
</head>
<body title="Atualize sua senha">
    <g:render template="/templates/headerNavBar"/>
    <atlas-panel>
        <atlas-form action="${createLink(controller: 'user', action: 'updatePassword')}" method="POST">
            <atlas-grid>
                <atlas-row>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-masked-input mask-alias="Email" label="Email" required="" size="md" value="${user.username}" name="email" disabled=""></atlas-masked-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="6" md="3" sm="1">
                            <atlas-password-input label="Senha" required="" name="password" size="md"></atlas-password-input>
                        </atlas-col>
                        <atlas-col lg="6" md="3" sm="1">
                            <atlas-password-input label="Confirmar senha" required="" name="passwordConfirm" size="md"></atlas-password-input>
                        </atlas-col>
                </atlas-row>
                <atlas-button submit description="Salvar" theme="primary"></atlas-button>
            </atlas-grid>
        </atlas-form>
        <g:if test="${flash.errors?.hasFieldErrors('password')}">
            <div>Por favor, preencha e confirme a senha corretamente</div>
        </g:if>
    </atlas-panel>
</body>
</html>
