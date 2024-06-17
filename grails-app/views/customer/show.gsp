<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="main">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Meus dados</title>
    </head>
    <body title="Meus dados">
        <g:render template="/templates/headerNavBar"/>
        <atlas-panel>
            <atlas-form class="js-person-form">
                <atlas-grid>
                    <atlas-row>
                        <atlas-col lg="6" md="3">
                            <atlas-input label="Nome Completo" required="" name="name" size="md" value="${customer.name}" disabled=""></atlas-input>
                        </atlas-col>
                        <atlas-col lg="6" md="3">
                            <atlas-masked-input mask-alias="cpf-cnpj" label="CPF/CNPJ" required="" size="md" name="cpfCnpj" value="${customer.cpfCnpj}" disabled=""></atlas-masked-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="6" md="3" sm="1">
                            <atlas-input label="Tipo de pessoa" required="" name="personType" size="md" value="${customer.personType.getLabel()}" disabled=""></atlas-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="6" md="3">
                            <atlas-masked-input mask-alias="email" label="Email" required="" name="email" size="md" value="${customer.email}" disabled=""></atlas-masked-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="4" md="2" sm="1">
                            <atlas-masked-input mask-alias="cell-phone" label="Celular" required="" name="mobilePhone" size="md" value="${customer.mobilePhone}" disabled=""></atlas-masked-input>
                        </atlas-col>
                        <atlas-col lg="4" md="2" sm="1">
                            <atlas-masked-input mask-alias="landline" label="Telefone" required="" name="phone" size="md" value="${customer.phone}" disabled=""></atlas-masked-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="4" md="2">
                            <atlas-postal-code label="CEP" required="" name="postalCode" size="md" value="${customer.postalCode}" disabled=""></atlas-postal-code>
                        </atlas-col>
                        <atlas-col lg="4" md="2">
                            <atlas-input label="Rua/Avenida/Alameda" required="" name="address" size="md" value="${customer.address}" disabled=""></atlas-input>
                        </atlas-col>
                        <atlas-col lg="4" md="2" sm="1">
                            <atlas-input label="Número" required="" name="addressNumber" size="md" value="${customer.addressNumber}" disabled=""></atlas-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="3" md="2">
                            <atlas-input label="Complemento" required="" name="addressComplement" size="md" value="${customer.addressComplement}" disabled=""></atlas-input>
                        </atlas-col>
                        <atlas-col lg="3" md="2">
                            <atlas-input label="Bairro" required="" name="district" size="md" value="${customer.district}" disabled=""></atlas-input>
                        </atlas-col>
                        <atlas-col lg="3" md="2">
                            <atlas-input label="Cidade" required="" name="city" size="md" value="${customer.city}" disabled=""></atlas-input>
                        </atlas-col>
                        <atlas-col lg="3" md="2" sm="1">
                            <atlas-input label="UF" required="" name="state" size="md" value="${customer.state}" disabled=""></atlas-input>
                        </atlas-col>
                    </atlas-row>
                </atlas-grid>
            </atlas-form>
        </atlas-panel>
    </body>
</html>