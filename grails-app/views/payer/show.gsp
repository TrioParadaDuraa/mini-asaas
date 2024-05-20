<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visualizar pagador</title>
</head>
<body>
    <form>
        <div>
            <label for="name">Nome</label>
            <br>
            <input name="name" value="${payer.name}" id="name" type="text" readonly>
        </div>
        <div>
            <label for="email">Email</label>
            <br>
            <input name="email" value="${payer.email}" id="email" type="email" readonly>
        </div>
        <div>
            <label for="personType">Tipo de pessoa</label>
            <br>
            <input name="personType" value="${payer.personType.getLabel()}" id="personType" type="text" readonly>
        </div>
    </form>
    <div>
        <a href="${createLink(controller: 'payer', action: 'edit', id: payer.id)}">Editar</a>
    </div>
</body>
</html>
