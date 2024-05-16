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
            <label>Nome</label>
            <br>
            <input type="text" name="name" value="${params.name}">
        </div>
        <div>
            <label>Email</label>
            <br>
            <input type="text" name="email" placeholder="email@email.com" value="${params.email}">
        </div>
        <div>
            <label>Telefone/Celular</label>
            <br>
            <input type="text" name="phone" placeholder="(00) 1234-5678 / (00) 9 1234-5678" maxlength="11" value="${params.phone}">
        </div>
        <div>
            <label>CPF/CNPJ</label>
            <br>
            <input type="text" name="cpfCnpj" placeholder="12345678900 ou 12345678900000" maxlength="14" value="${params.cpfCnpj}">
        </div>
        <div>
            <label>CEP</label>
            <br>
            <input type="text" name="postalCode" placeholder="12345678" maxlength="8" value="${params.postalCode}">
        </div>
        <div>
            <label>Endereco</label>
            <br>
            <input type="text" name="address" value="${params.address}">
        </div>
        <div>
            <label>Número</label>
            <br>
            <input type="text" name="addressNumber" value="${params.addressNumber}">
        </div>
        <div>
            <label>Complemento</label>
            <br>
            <input type="text" name="addressComplement" value="${params.addressComplement}">
        </div>
        <div>
            <label>Bairro</label>
            <br>
            <input type="text" name="district" value="${params.district}">
        </div>
        <div>
            <label>Cidade</label>
            <br>
            <input type="text" name="city" value="${params.city}">
        </div>
        <div>
            <label>Estado</label>
            <br>
            <input type="text" name="state" placeholder="MG" maxlength="2" id="state" value="${params.state}">
        </div>
        <button type="submit">Salvar</button>
        <g:if test="${flash.message}">
            <section>
                <div>
                    <p>${flash.message}</p>
                </div>
            </section>
        </g:if>
    </form>
</body>
</html>