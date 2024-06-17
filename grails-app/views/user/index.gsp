<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="main">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Usuários</title>
        <asset:stylesheet src="createUserForm.css"/>
        <asset:javascript src="errorMessage.js"/>
    </head>
    <body title="Usuários">
        <g:render template="/templates/headerNavBar"/>
        <atlas-panel>
            <g:render template="/templates/message/errorMessage"/>
            <atlas-form action="${createLink(controller: 'user', action: 'save')}" method="POST">
                <atlas-input label="Nome" name="name" value="${params.name}" class="form-field" required="" placeholder="Nome do usuário"></atlas-input>
                
                <atlas-masked-input label="Email" name="email" value="${params.email}" class="form-field" required="" mask-alias="email" placeholder="email@dominio.com">
                </atlas-masked-input>

                <atlas-password-input label="Senha" name="password" class="form-field" required=""></atlas-password-input>
                <atlas-password-input label="Confirme a senha" name="passwordConfirm" class="form-field" required="" size="md"></atlas-password-input>
                <div class="password-note">
                    <ul>
                        <li>A senha deve conter no mínimo 8 caracteres.</li>
                        <li>A senha deve conter pelo menos 1 número.</li>
                        <li>A senha deve conter pelo menos 1 letra.</li>
                    </ul>
                </div>
                <div class="form-action-buttons">
                    <atlas-button href="${createLink(controller: 'user', action: 'list')}" description="Cancelar" slot="actions" theme="danger"></atlas-button>
                    <atlas-button submit description="Criar usuário" slot="actions" theme="success"></atlas-button>
                </div>
            </atlas-form>
        </atlas-panel>
    </body>
</html>
