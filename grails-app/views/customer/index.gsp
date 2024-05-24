<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta name="layout" content="main">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de cliente</title>
</head>
<body page-title="Cadastro de cliente">
    <atlas-panel header="Cadastro de cliente">
        <atlas-form action="${createLink(controller: 'customer', action: 'save')}">
            <div class="top-form">
                <atlas-masked-input mask-alias="cpf-cnpj" label="CPF/CNPJ" required="" size="md"></atlas-masked-input>
                <atlas-input label="Nome Completo" required="" placeholder="Insira seu nome completo"></atlas-input>
                <atlas-masked-input mask-alias="email" label="Email" required="" size="md" placeholder="email@dominio.com"></atlas-masked-input>
                <atlas-masked-input mask-alias="cell-phone" label="Celular" required="" size="md"></atlas-masked-input>
                <atlas-masked-input mask-alias="landline" label="Telefone" size="md"></atlas-masked-input>
            </div>
            <div class="radio-container-horizontal">
                <input type="radio" checked style="position: absolute; opacity: 0">
            </div>
            <div class="bottom-form">
                <atlas-postal-code label="CEP" required=""></atlas-postal-code>
                <atlas-input label="Rua/Avenida/Alameda" required="" placeholder="Insira o endereço"></atlas-input>
                <atlas-input label="Número" required="" placeholder="Insira o número"></atlas-input>
                <atlas-input label="Complemento" required="" placeholder="Insira o complemento"></atlas-input>
                <atlas-input label="Bairro" required="" placeholder="Insira o bairro"></atlas-input>
                <atlas-input label="Cidade" required="" placeholder="Insira a cidade"></atlas-input>
                <atlas-input label="UF" required="" placeholder=""></atlas-input>
                <atlas-password-input label="Senha" required=""></atlas-password-input>
                <atlas-password-input label="Confirme sua senha" required=""></atlas-password-input>
            </div>
            <atlas-button description="Cancelar"></atlas-button>
            <atlas-button description="Criar conta"></atlas-button>
        </atlas-form>
    </atlas-panel>
</body>
</html>