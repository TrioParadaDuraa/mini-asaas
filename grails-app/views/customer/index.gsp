<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta name="layout" content="main">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de cliente</title>
    <style>
        .customer-create-buttons {
            display: flex;
            align-items: center;
            justify-content: center;
        }
        atlas-button {
            margin-right: 10px;
        }
        atlas-grid {
            margin-bottom: 15px;
        }
    </style>
</head>
<body page-title="Cadastro de cliente">
    <atlas-panel>
        <atlas-form action="${createLink(controller: 'customer', action: 'save')}">
            <atlas-grid>
                <atlas-row>
                    <atlas-col lg="5" md="3" sm="1">
                        <atlas-masked-input mask-alias="cpf-cnpj" label="CPF/CNPJ" required="" size="md"></atlas-masked-input>
                    </atlas-col>
                    <atlas-col lg="7" md="3" sm="1">
                        <atlas-input label="Nome Completo" required="" placeholder="Insira seu nome completo"></atlas-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="4" md="3">
                        <atlas-masked-input mask-alias="email" label="Email" required="" size="md" placeholder="email@dominio.com"></atlas-masked-input>
                    </atlas-col>
                    <atlas-col lg="4" md="3">
                        <atlas-masked-input mask-alias="cell-phone" label="Celular" required="" size="md"></atlas-masked-input>
                    </atlas-col>
                    <atlas-col lg="4" md="3">
                        <atlas-masked-input mask-alias="landline" label="Telefone" size="md"></atlas-masked-input>
                    </atlas-col>
                </atlas-row>
            </atlas-grid>
            <div class="radio-container-horizontal">
                <input type="radio">
                <label name="personType">pessoa fisica</label>
                <input type="radio">
                <label name="personType">pessoa juridica</label>
            </div>
            <atlas-grid>
                <atlas-row>
                    <atlas-col lg="5" md="3" sm="1">
                        <atlas-postal-code label="CEP" required=""></atlas-postal-code>
                    </atlas-col>
                    <atlas-col lg="7" md="3" sm="1">
                        <atlas-input label="Rua/Avenida/Alameda" required="" placeholder="Insira o endereço"></atlas-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="5" md="3" sm="1">
                        <atlas-input label="Número" required="" placeholder="Insira o número"></atlas-input>
                    </atlas-col>
                    <atlas-col lg="7" md="3" sm="1">
                        <atlas-input label="Complemento" placeholder="Insira o complemento"></atlas-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="5" md="3" sm="1">
                        <atlas-input label="Bairro" required="" placeholder="Insira o bairro"></atlas-input>
                    </atlas-col>
                    <atlas-col lg="5" md="3" sm="1">
                        <atlas-input label="Cidade" required="" placeholder="Insira a cidade"></atlas-input>
                    </atlas-col>
                    <atlas-col lg="2" md="1" sm="1">
                        <atlas-input label="UF" required="" placeholder=""></atlas-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="6" md="3">
                        <atlas-password-input label="Senha" required=""></atlas-password-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3">
                        <atlas-password-input label="Confirme sua senha" required=""></atlas-password-input>
                    </atlas-col>
                </atlas-row>
            </atlas-grid>
            <div class="customer-create-buttons">
                <atlas-button description="Cancelar" slot="actions"></atlas-button>
                <atlas-button description="Criar conta" slot="actions"></atlas-button>
            </div>
        </atlas-form>
    </atlas-panel>
</body>
</html>