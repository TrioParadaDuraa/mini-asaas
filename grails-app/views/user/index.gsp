<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Usuário</title>
</head>
<body>
    <form action="${createLink(controller: 'user', action: 'save')}" method="POST">
        <div>
            <label for="email">Email</label>
            <br>
            <input name="email" value="${params.email}" id="email" type="email">
        </div>
        <g:if test="${flash.errors?.hasFieldErrors('username')}">
            <div>Email inválido</div>
        </g:if>

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

        <div>
            <div>Sua senha deve conter, no mínimo:</div>
            <ul>
                <li>8 caracteres</li>
                <li>1 número</li>
                <li>1 letra</li>
            </ul>
        </div>

        <button type="submit">Salvar</button>
    </form>
</body>
</html>