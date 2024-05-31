<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="main">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Informações do customer</title>
    </head>
    <body>
        <atlas-form-panel header="Meus dados" class="js-person-form">
            <atlas-grid>
                <atlas-row>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Nome Completo" required="" name="name" size="md" value="${customer.name}"></atlas-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-masked-input mask-alias="cpf-cnpj" label="CPF/CNPJ" required="" size="md" name="cpfCnpj" value="${customer.cpfCnpj}"></atlas-masked-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Tipo de pessoa" required="" name="personType" size="md" value="${customer.personType.getLabel()}"></atlas-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="4" md="2" sm="1">
                        <atlas-masked-input mask-alias="email" label="Email" required="" name="email" size="md" value="${customer.email}"></atlas-masked-input>
                    </atlas-col>
                    <atlas-col lg="4" md="2" sm="1">
                        <atlas-masked-input mask-alias="cell-phone" label="Celular" required="" name="mobilePhone" size="md" value="${customer.mobilePhone}"></atlas-masked-input>
                    </atlas-col>
                    <atlas-col lg="4" md="2" sm="1">
                        <atlas-masked-input mask-alias="landline" label="Telefone" required="" name="phone" size="md" value="${customer.phone}"></atlas-masked-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="4" md="2" sm="1">
                        <atlas-postal-code label="CEP" required="" name="postalCode" size="md" value="${customer.postalCode}"></atlas-postal-code>
                    </atlas-col>
                    <atlas-col lg="4" md="2" sm="1">
                        <atlas-input label="Rua/Avenida/Alameda" required="" name="address" size="md" value="${customer.address}"></atlas-input>
                    </atlas-col>
                    <atlas-col lg="4" md="2" sm="1">
                        <atlas-input label="Número" required="" name="addressNumber" size="md" value="${customer.addressNumber}"></atlas-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="3" md="2" sm="1">
                        <atlas-input label="Complemento" required="" name="addressComplement" size="md" value="${customer.addressComplement}"></atlas-input>
                    </atlas-col>
                    <atlas-col lg="3" md="2" sm="1">
                        <atlas-input label="Bairro" required="" name="district" size="md" value="${customer.district}"></atlas-input>
                    </atlas-col>
                    <atlas-col lg="3" md="2" sm="1">
                        <atlas-input label="Cidade" required="" name="city" size="md" value="${customer.city}"></atlas-input>
                    </atlas-col>
                    <atlas-col lg="3" md="2" sm="1">
                        <atlas-input label="UF" required="" name="state" size="md" value="${customer.state}"></atlas-input>
                    </atlas-col>
                </atlas-row>
            </atlas-grid>
        </atlas-form-panel>
    </body>
</html>