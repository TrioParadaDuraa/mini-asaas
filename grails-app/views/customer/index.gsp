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
            <label for="name">Telefone/Celular</label>
            <br>
            <input type="text" id="phone" name="phone" placeholder="(00) 1234-5678 / (00) 9 1234-5678" maxlength="11" value="${params.phone}">
        </div>
        <div>
            <label for="cpfCnpj">CPF/CNPJ</label>
            <br>
            <input type="text" name="cpfCnpj" id="cpfCnpj" placeholder="12345678900 ou 12345678900000" maxlength="14" value="${params.cpfCnpj}">
        </div>
        <div>
            <label for="postalCode">CEP</label>
            <br>
            <input type="text" name="postalCode" id="postalCode" placeholder="12345678" maxlength="8" value="${params.postalCode}">
        </div>
        <div>
            <label for="address">Endereco</label>
            <br>
            <input type="text" name="address" id="address" value="${params.address}">
        </div>
        <div>
            <label for="address">Número</label>
            <br>
            <input type="text" name="addressNumber" id="addressNumber" value="${params.addressNumber}">
        </div>
        <div>
            <label for="address">Complemento</label>
            <br>
            <input type="text" name="addressComplement" id="addressComplement" value="${params.addressComplement}">
        </div>
        <div>
            <label for="address">Bairro</label>
            <br>
            <input type="text" name="district" id="district" value="${params.district}">
        </div>
        <div>
            <label for="city">Cidade</label>
            <br>
            <input type="text" name="city" id="city" value="${params.city}">
        </div>
        <div>
            <label for="state">Estado</label>
            <br>
            <input type="text" name="state" placeholder="MG" maxlength="2" id="state" value="${params.state}">
        </div>
        <button type="submit">Salvar</button>
    </form>
</body>
</html>