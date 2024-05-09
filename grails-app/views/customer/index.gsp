<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form method="POST" action="${createLink(controller: "customer", action: "save")}">
        <div>
            <label for="name">Nome</label>
            <br>
            <input type="text" id="name" name="name" value="${params.name}">
        </div>
        <div>
            <label for="name">Email</label>
            <br>
            <input type="text" id="email" name="email" placeholder="email@email.com" value="${params.email}">
        </div>
        <div>
            <label for="cpfOrCnpj">CPF/CNPJ</label>
            <br>
            <input type="text" name="cpfOrCnpj" id="cpfOrCnpj" placeholder="12345678900 ou 12345678900000"maxlength="14" value="${params.cpfOrCnpj}">
        </div>
        <div>
            <label for="cep">CEP</label>
            <br>
            <input type="text" name="cep" id="cep" maxlength="9" placeholder="12345678" value="${params.cep}">
        </div>
        <div>
            <label for="endereco">endereco</label>
            <br>
            <input type="text" name="endereco" id="endereco" value="${params.endereco}">
        </div>
        <div>
            <label for="cidade">cidade</label>
            <br>
            <input type="text" name="cidade" id="cidade" value="${params.cidade}">
        </div>
        <div>
            <label for="estado">estado</label>
            <br>
            <input type="text" name="estado" placeholder="MG" id="estado" value="${params.estado}">
        </div>
        <button type="submit">Salvar</button>
    </form>
</body>
</html>