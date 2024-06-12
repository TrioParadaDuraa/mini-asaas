<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="main">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Editar pagador</title>
    </head>
    <body>
        <atlas-panel header="Atualize os dados do pagador">
            <atlas-form method="POST" action="${createLink(controller: 'payer', action: 'update', id: payer.id)}">
                <atlas-grid>
                    <atlas-row>
                        <atlas-col lg="6" md="2" sm="1">
                            <atlas-input label="Nome do pagador:" required="" size="md" value="${payer.name}"></atlas-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="6" md="2" sm="1">
                            <atlas-masked-input mask-alias="email" label="Email:" required="" size="md" value="${payer.email}"></atlas-masked-input>
                        </atlas-col>
                        <atlas-col lg="3" md="2" sm="1">
                            <atlas-masked-input mask-alias="landline" label="Telefone:" size="md" value="${payer.phone}"></atlas-masked-input>
                        </atlas-col>
                        <atlas-col lg="3" md="2" sm="1">
                            <atlas-masked-input mask-alias="cell-phone" label="Celular:" required="" size="md" value="${payer.mobilePhone}"></atlas-masked-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="5" md="3" sm="1">
                            <atlas-postal-code label="CEP" required="" size="md" value="${payer.postalCode}"></atlas-postal-code>
                        </atlas-col>
                        <atlas-col lg="7" md="3" sm="1">
                            <atlas-input label="Rua/Avenida/Alameda" required="" size="md" value="${payer.address}"></atlas-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="3" md="2" sm="1">
                            <atlas-input label="Número" required="" size="md" value="${payer.addressNumber}"></atlas-input>
                        </atlas-col>
                        <atlas-col lg="4" md="3" sm="1">
                            <atlas-input label="Complemento" size="md" value="${payer.addressComplement}"></atlas-input>
                        </atlas-col>
                        <atlas-col lg="5" md="2" sm="1">
                            <atlas-input label="Bairro" required="" size="md" value="${payer.district}"></atlas-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="5" md="2" sm="1">
                            <atlas-input label="Cidade" required="" size="md" value="${payer.city}"></atlas-input>
                        </atlas-col>
                        <atlas-col lg="2" md="2" sm="1">
                            <atlas-input label="UF" required="" size="md" value="${payer.state}"></atlas-input>
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