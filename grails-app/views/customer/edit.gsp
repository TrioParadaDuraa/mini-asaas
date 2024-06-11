<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="main">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Atualizar dados</title>
    </head>
    <body title="Atualize seus dados cadastrais">
        <g:render template="templates/headerNavBar"/>
        <atlas-form-panel class="js-person-form" method="POST" action="${createLink(controller: 'customer', action: 'update', id: customer.id)}">
            <atlas-grid>
                <atlas-row>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Nome" required="" name="name" size="md" value="${customer.name}"></atlas-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="3" md="2" sm="1">
                        <atlas-masked-input mask-alias="email" label="Email" required="" name="email" size="md" value="${customer.email}"></atlas-masked-input>
                    </atlas-col>
                    <atlas-col lg="2" md="2" sm="1">
                        <atlas-masked-input mask-alias="cell-phone" label="Celular" required="" name="mobilePhone" size="md" value="${customer.mobilePhone}"></atlas-masked-input>
                    </atlas-col>
                    <atlas-col lg="2" md="2" sm="1">
                        <atlas-masked-input mask-alias="landline" label="Telefone" required="" name="phone" size="md" value="${customer.phone}"></atlas-masked-input>
                    </atlas-col>
                    <atlas-col lg="5" md="2" sm="1">
                        <atlas-postal-code label="CEP" required="" name="postalCode" size="md" value="${customer.postalCode}"></atlas-postal-code>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="4" md="2" sm="1">
                        <atlas-input label="Rua/Avenida/Alameda" required="" name="address" size="md" value="${customer.address}"></atlas-input>
                    </atlas-col>
                    <atlas-col lg="4" md="2" sm="1">
                        <atlas-input label="Número" required="" name="addressNumber" size="md" value="${customer.addressNumber}"></atlas-input>
                    </atlas-col>
                    <atlas-col lg="4" md="2" sm="1">
                        <atlas-input label="Complemento" required="" name="addressComplement" size="md" value="${customer.addressComplement}"></atlas-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="4" md="2" sm="1">
                        <atlas-input label="Bairro" required="" name="district" size="md" value="${customer.district}"></atlas-input>
                    </atlas-col>
                    <atlas-col lg="4" md="2" sm="1">
                        <atlas-input label="Cidade" required="" name="city" size="md" value="${customer.city}"></atlas-input>
                    </atlas-col>
                    <atlas-col lg="1" md="1" sm="1">
                        <atlas-input label="UF" required="" name="state" size="md" value="${customer.state}"></atlas-input>
                    </atlas-col>
                </atlas-row>
            </atlas-grid>
            <div class="bottom-buttons">
                <atlas-button description="Editar" data-panel-start-editing icon="pencil" slot="actions" theme="primary"></atlas-button>
            </div>
        </atlas-form-panel>
    </body>
</html>