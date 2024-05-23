<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Informações do customer</title>
    </head>
    <body>
        <form method="POST" action="${createLink(controller: 'customer', action: 'update')}">
            <input type="hidden" name="id" value="${customer.id}">
            <div>
                <label>Nome</label>
                <br>
                <input type="text" class="js-update-input" name="name" value="${customer.name}">
            </div>
            <br>
            <div>
                <label>Email</label>
                <br>
                <input type="email" class="js-update-input" name="email" value="${customer.email}">
            </div>
            <br>
            <div>
                <label>CPF/CNPJ</label>
                <br>
                <input type="text" name="cpfCnpj" value="${customer.cpfCnpj}">
            </div>
            <br>
            <div>
                <label>Telefone</label>
                <br>
                <input type="text" class="js-update-input" name="phone" value="${customer.phone}">
            </div>
            <br>
            <div>
                <label>Celular</label>
                <br>
                <input type="text" class="js-update-input" name="mobilePhone" value="${customer.mobilePhone}">
            </div>
            <br>
            <div>
                <label>Tipo de pessoa</label>
                <br>
                <input type="text" name="personType" value="${customer.personType.getLabel()}">
            </div>
            <br>
            <div>
                <label>CEP</label>
                <br>
                <input type="text" class="js-update-input" name="postalCode" value="${customer.postalCode}">
            </div>
            <br>
            <div>
                <label>Endereço</label>
                <br>
                <input type="text" class="js-update-input" name="address" value="${customer.address}">
            </div>
            <br>
            <div>
                <label>Número</label>
                <br>
                <input type="text" class="js-update-input" name="addressNumber" value="${customer.addressNumber}">
            </div>
            <br>
            <div>
                <label>Complemento</label>
                <br>
                <input type="text" class="js-update-input" name="addressComplement" value="${customer.addressComplement}">
            </div>
            <br>
            <div>
                <label>Bairro</label>
                <br>
                <input type="text" class="js-update-input" name="district" value="${customer.district}">
            </div>
            <br>
            <div>
                <label>Cidade</label>
                <br>
                <input type="text" class="js-update-input" name="city" value="${customer.city}">
            </div>
            <br>
            <div>
                <label>Estado</label>
                <br>
                <input type="text" class="js-update-input" name="state" value="${customer.state}">
            </div>
            <br>
            <button type="submit">Salvar</button>
        </form>
    </body>
</html>