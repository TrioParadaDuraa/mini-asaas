<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="main">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Editar pagador</title>
        <asset:javascript src="errorMessage.js"/>
    </head>
    <body>
        <atlas-panel header="Atualize os dados do pagador">
            <g:render template="/templates/message/errorMessage"/>
            <atlas-form method="POST" action="${createLink(controller: 'payer', action: 'update', id: payer.id)}">
                <atlas-grid>
                    <atlas-row>
                        <atlas-col lg="6" md="2" sm="1">
                            <atlas-input label="Nome do pagador:" required="" size="md" name="name" value="${flash.oldFormData?.name ?: payer.name}"></atlas-input>
                        </atlas-col>
                        <atlas-col lg="3" md="2" sm="1">
                            <atlas-input label="Tipo de pessoa:" required="" size="md" name="personType" value="${payer.personType.getLabel()}" disabled=""></atlas-input>
                        </atlas-col>
                        <atlas-col lg="3" md="2" sm="1">
                            <atlas-masked-input mask-alias="cpf-cnpj" label="CPF/CNPJ:" required="" size="md" name="cpfCnpj" value="${payer.cpfCnpj}" disabled=""></atlas-masked-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="6" md="2" sm="1">
                            <atlas-masked-input mask-alias="email" label="Email:" required="" size="md" name="email" value="${flash.oldFormData?.email ?: payer.email}"></atlas-masked-input>
                        </atlas-col>
                        <atlas-col lg="3" md="2" sm="1">
                            <atlas-masked-input mask-alias="landline" label="Telefone:" size="md" name="phone" value="${flash.oldFormData?.phone ?: payer.phone}"></atlas-masked-input>
                        </atlas-col>
                        <atlas-col lg="3" md="2" sm="1">
                            <atlas-masked-input mask-alias="cell-phone" label="Celular:" required="" size="md" name="mobilePhone" value="${flash.oldFormData?.mobilePhone ?: payer.mobilePhone}"></atlas-masked-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="5" md="3" sm="1">
                            <atlas-postal-code label="CEP" required="" size="md" name="postalCode" value="${flash.oldFormData?.postalCode ?: payer.postalCode}"></atlas-postal-code>
                        </atlas-col>
                        <atlas-col lg="7" md="3" sm="1">
                            <atlas-input label="Rua/Avenida/Alameda" required="" size="md" name="address" value="${flash.oldFormData?.address ?: payer.address}"></atlas-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="5" md="3" sm="1">
                            <atlas-input label="Número" size="md" name="addressNumber" value="${flash.oldFormData?.addressNumber ?: payer.addressNumber}"></atlas-input>
                        </atlas-col>
                        <atlas-col lg="7" md="3" sm="1">
                            <atlas-input label="Complemento" size="md" name="addressComplement" value="${flash.oldFormData?.addressComplement ?: payer.addressComplement}"></atlas-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="5" md="2" sm="1">
                            <atlas-input label="Bairro" required="" size="md" name="district" value="${flash.oldFormData?.district ?: payer.district}"></atlas-input>
                        </atlas-col>
                        <atlas-col lg="5" md="2" sm="1">
                            <atlas-input label="Cidade" required="" size="md" name="city" value="${flash.oldFormData?.city ?: payer.city}"></atlas-input>
                        </atlas-col>
                        <atlas-col lg="2" md="2" sm="1">
                            <atlas-input label="UF" required="" size="md" name="state" value="${flash.oldFormData?.state ?: payer.state}"></atlas-input>
                        </atlas-col>
                    </atlas-row>
                </atlas-grid>
                <div class="bottom-buttons">
                    <atlas-button description="Cancelar" slot="actions" theme="danger" href="${createLink(controller: 'payer', action: 'show', id: payer.id)}"></atlas-button>
                    <atlas-button submit description="Editar" slot="actions" theme="success"></atlas-button>
                </div>
            </atlas-form>
        </atlas-panel>
    </body>
</html>
