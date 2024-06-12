<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta name="layout" content="main">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar pagador</title>
</head>
<body>
<atlas-form-panel header="Atualize os dados do pagador">
    <atlas-grid>
        <atlas-row>
            <atlas-col lg="6" md="2" sm="1">
                <atlas-input label="Nome do pagador:" required="" size="md" value="${payer.name}" disabled=""></atlas-input>
            </atlas-col>
        </atlas-row>
        <atlas-row>
            <atlas-col lg="6" md="2" sm="1">
                <atlas-masked-input mask-alias="email" label="Email:" required="" size="md" value="${payer.email}" disabled=""></atlas-masked-input>
            </atlas-col>
            <atlas-col lg="3" md="2" sm="1">
                <atlas-masked-input mask-alias="landline" label="Telefone:" size="md" value="${payer.phone}" disabled=""></atlas-masked-input>
            </atlas-col>
            <atlas-col lg="3" md="2" sm="1">
                <atlas-masked-input mask-alias="cell-phone" label="Celular:" required="" size="md" value="${payer.mobilePhone}" disabled=""></atlas-masked-input>
            </atlas-col>
        </atlas-row>
        <atlas-row>
            <atlas-col lg="5" md="3" sm="1">
                <atlas-postal-code label="CEP" required="" size="md" value="${payer.postalCode}" disabled=""></atlas-postal-code>
            </atlas-col>
            <atlas-col lg="7" md="3" sm="1">
                <atlas-input label="Rua/Avenida/Alameda" required="" size="md" value="${payer.address}" disabled=""></atlas-input>
            </atlas-col>
        </atlas-row>
        <atlas-row>
            <atlas-col lg="3" md="2" sm="1">
                <atlas-input label="Número" required="" size="md" value="${payer.addressNumber}" disabled=""></atlas-input>
            </atlas-col>
            <atlas-col lg="4" md="3" sm="1">
                <atlas-input label="Complemento" size="md" value="${payer.addressComplement}" disabled=""></atlas-input>
            </atlas-col>
            <atlas-col lg="5" md="2" sm="1">
                <atlas-input label="Bairro" required="" size="md" value="${payer.district}" disabled=""></atlas-input>
            </atlas-col>
        </atlas-row>
        <atlas-row>

            <atlas-col lg="5" md="2" sm="1">
                <atlas-input label="Cidade" required="" size="md" value="${payer.city}" disabled=""></atlas-input>
            </atlas-col>
            <atlas-col lg="2" md="2" sm="1">
                <atlas-input label="UF" required="" size="md" value="${payer.state}" disabled=""></atlas-input>
            </atlas-col>
        </atlas-row>
    </atlas-grid>
    <div class="bottom-buttons">
        <atlas-button description="Editar" slot="actions" theme="success" href="${createLink(controller: 'payer', action: 'update', id: payer.id)}"></atlas-button>
        <atlas-button description="Cancelar" slot="actions" theme="danger" href="${createLink(controller: 'payer', action: 'show', id: payer.id)}"></atlas-button>
    </div>
</atlas-form-panel>
</body>
</html>
