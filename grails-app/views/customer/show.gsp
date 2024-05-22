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
                <input type="text" class="update-input" name="name" value="${customer.name}" readonly>
            </div>
            <br>
            <div>
                <label>Email</label>
                <br>
                <input type="email" class="update-input" name="email" value="${customer.email}" readonly>
            </div>
            <br>
            <div>
                <label>CPF/CNPJ</label>
                <br>
                <input type="text" name="cpfCnpj" value="${customer.cpfCnpj}" readonly>
            </div>
            <br>
            <div>
                <label>Telefone</label>
                <br>
                <input type="text" class="update-input" name="phone" value="${customer.phone}" readonly>
            </div>
            <br>
            <div>
                <label>Celular</label>
                <br>
                <input type="text" class="update-input" name="mobilePhone" value="${customer.mobilePhone}" readonly>
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
                <input type="text" class="update-input" name="postalCode" value="${customer.postalCode}" readonly>
            </div>
            <br>
            <div>
                <label>Endereço</label>
                <br>
                <input type="text" class="update-input" name="address" value="${customer.address}" readonly>
            </div>
            <br>
            <div>
                <label>Número</label>
                <br>
                <input type="text" class="update-input" name="addressNumber" value="${customer.addressNumber}" readonly>
            </div>
            <br>
            <div>
                <label>Complemento</label>
                <br>
                <input type="text" class="update-input" name="addressComplement" value="${customer.addressComplement}" readonly>
            </div>
            <br>
            <div>
                <label>Bairro</label>
                <br>
                <input type="text" class="update-input" name="district" value="${customer.district}" readonly>
            </div>
            <br>
            <div>
                <label>Cidade</label>
                <br>
                <input type="text" class="update-input" name="city" value="${customer.city}" readonly>
            </div>
            <br>
            <div>
                <label>Estado</label>
                <br>
                <input type="text" class="update-input" name="state" value="${customer.state}" readonly>
            </div>
            <br>
            <button id="edit-button" type="button">Habilitar edição</button>
            <button type="submit">Salvar</button>
        </form>
        <asset:javascript src="editScript.js"/>
    </body>
</html>