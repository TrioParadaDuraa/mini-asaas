<%@ page import="com.mini.asaas.utils.base.PersonType; com.mini.asaas.utils.enums.BrazilianState; com.mini.asaas.payer.Payer" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="main">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Criar Pagador</title>
        <asset:javascript src="payerInputUpdate.js"/>
    </head>
    <body>
        <atlas-panel header="Cadastro de pagador">
            <atlas-form method="POST" action="${createLink(controller: 'payer', action: 'save')}">
                <atlas-grid>
                    <atlas-col>
                        <p>Tipo de pessoa:</p>
                        <atlas-toggle name="personType">
                            <atlas-toggle-item value="${PersonType.NATURAL}" label="Pessoa física"></atlas-toggle-item>
                            <atlas-toggle-item value="${PersonType.LEGAL}" label="Pessoa juridica"></atlas-toggle-item>
                        </atlas-toggle>
                    </atlas-col>

                    <atlas-col lg="3" md="2" sm="1">
                        <atlas-masked-input mask-alias="cpf-cnpj" label="CPF/CNPJ" size="md" name="cpfCnpj" id="js-cpf-cnpj" value="${params.cpfCnpj}" required="" disabled=""></atlas-masked-input>
                    </atlas-col>

                    <atlas-col lg="7" md="4" sm="1">
                        <atlas-input label="Nome Completo" required="" placeholder="Insira seu nome completo" size="md" name="name" value="${params.name}"></atlas-input>
                    </atlas-col>

                    <atlas-col lg="3" md="1" sm="1">
                        <atlas-masked-input mask-alias="email" label="Email" size="md" name="email" id="email" value="${params.email}" required="" disabled=""></atlas-masked-input>
                    </atlas-col>

                    <atlas-col lg="3" md="1" sm="1">
                        <atlas-masked-input mask-alias="cell-phone" label="Celular" size="md" name="mobilePhone" id="mobile-phone" value="${params.mobilePhone}" required="" disabled=""></atlas-masked-input>
                    </atlas-col>

                    <atlas-col lg="3" md="1" sm="1">
                        <atlas-masked-input mask-alias="landline" label="Telefone" size="md" name="phone" id="phone" value="${params.phone}" required="" disabled=""></atlas-masked-input>
                    </atlas-col>

                    <atlas-col lg="5" md="3" sm="1">
                        <atlas-postal-code label="CEP" required="" name="postalCode" size="md" value="${params.postalCode}"></atlas-postal-code>
                    </atlas-col>

                    <atlas-col lg="7" md="3" sm="1">
                        <atlas-input label="Rua/Avenida/Alameda" required="" placeholder="Insira o endereço" name="address" size="md" value="${params.address}"></atlas-input>
                    </atlas-col>

                    <atlas-col lg="5" md="3" sm="1">
                        <atlas-input label="Número" required="" placeholder="Insira o número" name="addressNumber" size="md" value="${params.addressNumber}"></atlas-input>
                    </atlas-col>

                    <atlas-col lg="7" md="3" sm="1">
                        <atlas-input label="Complemento" placeholder="Insira o complemento" name="addressComplement" size="md" value="${params.addressComplement}"></atlas-input>
                    </atlas-col>

                    <atlas-row>
                        <atlas-col lg="5" md="2" sm="1">
                            <atlas-input label="Bairro" required="" placeholder="Insira o bairro" name="district" size="md" value="${params.district}"></atlas-input>
                        </atlas-col>
                        <atlas-col lg="5" md="2" sm="1">
                            <atlas-input label="Cidade" required="" placeholder="Insira a cidade" name="city" size="md" value="${params.city}"></atlas-input>
                        </atlas-col>
                        <atlas-col lg="2" md="2" sm="1">
                            <atlas-input label="UF" required="" placeholder="" name="state" size="md" value="${params.state}"></atlas-input>
                        </atlas-col>
                    </atlas-row>
                </atlas-grid>

                <div class="bottom-buttons">
                    <atlas-button description="Cancelar" slot="actions" theme="danger"></atlas-button>
                    <atlas-button submit description="Salvar" slot="actions" theme="success"></atlas-button>
                </div>
            </atlas-form>
        </atlas-panel>
    </body>
</html>
