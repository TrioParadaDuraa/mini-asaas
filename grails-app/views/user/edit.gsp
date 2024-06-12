<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alterar senha</title>
</head>
<body>
    <form action="${createLink(controller: 'user', action: 'updatePassword')}" method="POST">
        <div>
            <label for="email">Email</label>
            <br>
            <input name="email" value="${user.username}" id="email" type="email" disabled>
        </div>

        <div>
            <label for="password">Senha</label>
            <br>
            <input name="password" id="password" type="password">
        </div>

        <div>
            <label for="passwordConfirm">Confirmar senha</label>
            <br>
            <input name="passwordConfirm" id="passwordConfirm" type="password">
        </div>
        <g:if test="${flash.errors?.hasFieldErrors('password')}">
            <div>Por favor, preencha e confirme a senha corretamente</div>
        </g:if>

        <button type="submit">Salvar</button>
    </form>
</body>
</html>