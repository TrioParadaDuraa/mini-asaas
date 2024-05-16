<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form method="POST" action="${createLink(controller: "payer", action: "save")}">
        <div>
            <label for="cpfCnpj">CPF/CNPJ</label>
            <br>
            <input name="cpfCnpj" value="${params.cpfCnpj}" id="cpfCnpj" type="text" maxlength="14">
        </div>
        <div>
            <label for="name">Nome</label>
            <br>
            <input name="name" value="${params.name}" id="name" type="text">
        </div>
        <div>
            <label for="email">Email</label>
            <br>
            <input name="email" value="${params.email}" id="email" type="text">
        </div>
        <div>
            <label for="phone">Telefone</label>
            <br>
            <input name="phone" value="${params.phone}" id="phone" type="text" maxlength="14">
        </div>
        <div>
            <label for="postalCode">CEP</label>
            <br>
            <input name="postalCode" value="${params.postalCode}" id="postalCode" type="text" maxlength="8">
        </div>
        <div>
            <label for="address">Endereço</label>
            <br>
            <input name="address" value="${params.address}" id="address" type="text">
        </div>
        <div>
            <label for="addressNumber">Número</label>
            <br>
            <input name="addressNumber" value="${params.addressNumber}" id="addressNumber" type="text">
        </div>
        <div>
            <label for="addressComplement">Complemento</label>
            <br>
            <input name="addressComplement" value="${params.addressComplement}" id="addressComplement" type="text">
        </div>
        <div>
            <label for="district">Bairro</label>
            <br>
            <input name="district" value="${params.district}" id="district" type="text">
        </div>
        <div>
            <label for="city">Cidade</label>
            <br>
            <input name="city" value="${params.city}" id="city" type="text">
        </div>
        <div>
            <label for="state">Estado</label>
            <br>
            <input name="state" value="${params.state}" id="state" type="text">
        </div>
        <button type="submit">Salvar</button>
    </form>
</body>
</html>