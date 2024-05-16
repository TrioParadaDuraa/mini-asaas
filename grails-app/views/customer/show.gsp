<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    </head>
    <body>
        <form>
            <div>
                <label>Nome</label>
                <br>
                <input type="text" name="name" value="${customer.name}" readonly>
            </div>
            <br>
            <div>
                <label>Email</label>
                <br>
                <input type="email" name="email" value="${customer.email}" readonly>
            </div>
            <br>
            <div>
                <label>CPF/CNPJ</label>
                <br>
                <input type="text" name="cpfCnpj" value="${customer.cpfCnpj}" readonly>
            </div>
            <br>
            <div>
                <label>Telefone/Celular</label>
                <br>
                <input type="text" name="phone" value="${customer.phone}" readonly>
            </div>
            <br>
            <div>
                <label>Tipo de pessoa</label>
                <br>
                <input type="text" name="personType" value="${customer.personType.getLabel()}" readonly>
            </div>
            <br>
            <div>
                <label>CEP</label>
                <br>
                <input type="text" name="postalCode" value="${customer.postalCode}" readonly>
            </div>
            <br>
            <div>
                <label>Endereço</label>
                <br>
                <input type="text" name="address" value="${customer.address}" readonly>
            </div>
            <br>
            <div>
                <label>Número do endereço</label>
                <br>
                <input type="text" name="addressNumber" value="${customer.addressNumber}" readonly>
            </div>
            <br>
            <div>
                <label>Complemento</label>
                <br>
                <input type="text" name="addressComplement" value="${customer.addressComplement}" readonly>
            </div>
            <br>
            <div>
                <label>Bairro</label>
                <br>
                <input type="text" name="district" value="${customer.district}" readonly>
            </div>
            <br>
            <div>
                <label>Cidade</label>
                <br>
                <input type="text" name="city" value="${customer.city}" readonly>
            </div>
            <br>
            <div>
                <label>Estado</label>
                <br>
                <input type="text" name="state" value="${customer.state}" readonly>
            </div>
            <br>
            <g:link controller="customer" action="update" params="[id: customer.id]">
            <button type="button">Editar dados</button>
            </g:link>
        </form>
    </body>
</html>