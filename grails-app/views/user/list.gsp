<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuários</title>
</head>
<body>
    <h1>Usuários</h1>
    <table>
        <tr>
            <th>Email de acesso</th>
        </tr>
        <g:each var="user" in="${userList}">
            <tr>
                <td>${user.username}</td>
            </tr>
        </g:each>
    </table>
</body>
</html>