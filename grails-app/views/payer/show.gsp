<%@ page import="com.mini.asaas.utils.base.PersonType" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta name="layout" content="main">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visualizar pagador</title>
</head>
    <body>
        <atlas-panel header="Dados do pagador">
            <atlas-grid>
                <atlas-row>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Nome do pagador:" required="" size="md" value="${payer.name}" disabled=""></atlas-input>
                    </atlas-col>
                    <div>
                        <label for="personType">Tipo de pessoa</label>
                        <br>
                        <input type="text" value="${payer.personType.getLabel()}" readonly>
                        <select name="personType" id="personType">
                            <g:each var="value" in="${PersonType.values()}">
                                <option value="${value}">${value.getLabel()}</option>
                            </g:each>
                        </select>
                        <atlas-col lg="6" md="3" sm="1">
                            <atlas-input label="Tipo de pessoa:" required="" size="md" value="${payer.personType.getLabel()}" disabled=""></atlas-input>
                        </atlas-col>
                    </div>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-masked-input mask-alias="cpf-cnpj" label="CPF/CNPJ:" required="" size="md" value="${payer.cpfCnpj}" disabled=""></atlas-masked-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-masked-input mask-alias="email" label="Email:" required="" size="md" value="${payer.email}" disabled=""></atlas-masked-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-masked-input mask-alias="landline" label="Telefone:" size="md" value="${payer.phone}" disabled=""></atlas-masked-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-masked-input mask-alias="cell-phone" label="Celular:" required="" size="md" value="${payer.mobilePhone}" disabled=""></atlas-masked-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="5" md="3" sm="1">
                        <atlas-postal-code label="CEP" required="" name="postalCode" size="md" value="${params.postalCode}"></atlas-postal-code>
                    </atlas-col>
                    <atlas-col lg="7" md="3" sm="1">
                        <atlas-input label="Rua/Avenida/Alameda" required="" placeholder="Insira o endereço" name="address" size="md" value="${params.address}"></atlas-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="5" md="3" sm="1">
                        <atlas-input label="Número" required="" placeholder="Insira o número" name="addressNumber" size="md" value="${params.addressNumber}"></atlas-input>
                    </atlas-col>
                    <atlas-col lg="7" md="3" sm="1">
                        <atlas-input label="Complemento" placeholder="Insira o complemento" name="addressComplement" size="md" value="${params.addressComplement}"></atlas-input>
                    </atlas-col>
                </atlas-row>
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
            <g:if test="${payer.deleted}">
                <atlas-button description="Restaurar" slot="actions" href="${createLink(controller: 'payer', action: 'restore', id: payer.id)}"></atlas-button>
            </g:if>
            <g:else>
                <atlas-button description="Excluir" slot="actions" theme="danger" href="${createLink(controller: 'payer', action: 'delete', id: payer.id)}"></atlas-button>
            </g:else>
        </atlas-panel>
    </body>
</html>