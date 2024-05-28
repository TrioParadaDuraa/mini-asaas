<%@ page import="com.mini.asaas.utils.base.PersonType" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta name="layout" content="main">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de cliente</title>
</head>
<body title="Cadastro de cliente">
    <atlas-panel>
        <atlas-form action="${createLink(controller: 'register', action: 'save')}">
            <atlas-grid>
                <atlas-row>
                    <atlas-col lg="5" md="2" sm="1">
                        <atlas-masked-input mask-alias="cpf-cnpj" label="CPF/CNPJ" required="" size="md" name="cpfCnpj" value="${params.cpfCnpj}"></atlas-masked-input>
                    </atlas-col>
                    <atlas-col lg="7" md="4" sm="1">
                        <atlas-input label="Nome Completo" required="" placeholder="Insira seu nome completo" name="name" value="${params.name}"></atlas-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="4" md="2" sm="1">
                        <atlas-masked-input mask-alias="email" label="Email" required="" size="md" placeholder="email@dominio.com" name="email" value="${params.email}"></atlas-masked-input>
                    </atlas-col>
                    <atlas-col lg="4" md="2" sm="1">
                        <atlas-masked-input mask-alias="cell-phone" label="Celular" required="" size="md" name="mobilePhone" value="${params.mobilePhone}"></atlas-masked-input>
                    </atlas-col>
                    <atlas-col lg="4" md="2" sm="1">
                        <atlas-masked-input mask-alias="landline" label="Telefone" size="md" name="phone" value="${params.phone}"></atlas-masked-input>
                    </atlas-col>
                </atlas-row>
            </atlas-grid>
            <div>
                <p>Tipo de pessoa:</p>
                <atlas-toggle name="personType">
                    <atlas-toggle-item value="${PersonType.NATURAL}" label="Pessoa física"></atlas-toggle-item>
                    <atlas-toggle-item value="${PersonType.LEGAL}" label="Pessoa juridica"></atlas-toggle-item>
                </atlas-toggle>
            </div>
            <atlas-grid>
                <atlas-row>
                    <atlas-col lg="5" md="3" sm="1">
                        <atlas-postal-code label="CEP" required="" name="postalCode" value="${params.postalCode}"></atlas-postal-code>
                    </atlas-col>
                    <atlas-col lg="7" md="3" sm="1">
                        <atlas-input label="Rua/Avenida/Alameda" required="" placeholder="Insira o endereço" name="address" value="${params.address}"></atlas-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="5" md="3" sm="1">
                        <atlas-input label="Número" required="" placeholder="Insira o número" name="addressNumber" value="${params.addressNumber}"></atlas-input>
                    </atlas-col>
                    <atlas-col lg="7" md="3" sm="1">
                        <atlas-input label="Complemento" placeholder="Insira o complemento" name="addressComplement" value="${params.addressComplement}"></atlas-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="5" md="2" sm="1">
                        <atlas-input label="Bairro" required="" placeholder="Insira o bairro" name="district" value="${params.district}"></atlas-input>
                    </atlas-col>
                    <atlas-col lg="5" md="2" sm="1">
                        <atlas-input label="Cidade" required="" placeholder="Insira a cidade" name="city" value="${params.city}"></atlas-input>
                    </atlas-col>
                    <atlas-col lg="2" md="2" sm="1">
                        <atlas-input label="UF" required="" placeholder="" name="state" value="${params.state}"></atlas-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="6" md="3">
                        <atlas-password-input label="Senha" required="" name="password"></atlas-password-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3">
                        <atlas-password-input label="Confirme sua senha" required="" name="passwordConfirm"></atlas-password-input>
                    </atlas-col>
                </atlas-row>
                <div class="password-note">
                    <ul>
                        <li>Sua senha deve conter no mínimo 8 caracteres.</li>
                        <li>Sua senha deve conter pelo menos 1 número.</li>
                        <li>Sua senha deve conter pelo menos 1 letra.</li>
                    </ul>
                </div>
            </atlas-grid>
            <div class="bottom-buttons">
                    <atlas-button description="Cancelar" slot="actions" theme="danger"></atlas-button>
                    <atlas-button submit description="Criar conta" slot="actions" theme="success"></atlas-button>
            </div>
            <div class="bottom-text">
                <a href="/">Já tem uma conta ?</a>
            </div>
        </atlas-form>
    </atlas-panel>
</body>
</html>