<%@ page import="com.mini.asaas.utils.base.PersonType" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="external">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastro de cliente</title>
        <asset:stylesheet src="errornotify.css"/>
        <asset:javascript src="errorMessage.js"/>
    </head>
    <body title="Cadastro de cliente">
        <atlas-panel>
            <g:render template="/templates/message/errorMessage"/>
            <atlas-form method="POST" action="${createLink(controller: 'customer', action: 'save')}">
                <atlas-grid>
                    <atlas-row>
                        <atlas-col lg="5" md="2" sm="1">
                            <atlas-masked-input mask-alias="cpf-cnpj" label="CPF/CNPJ" required="" size="md" name="cpfCnpj" value="${flash.oldFormData?.cpfCnpj}"></atlas-masked-input>
                        </atlas-col>
                        <atlas-col lg="7" md="4" sm="1">
                            <atlas-input label="Nome Completo" required="" placeholder="Insira seu nome completo" size="md" name="name" value="${flash.oldFormData?.name}"></atlas-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="4" md="2" sm="1">
                            <atlas-masked-input mask-alias="email" label="Email" required="" size="md" placeholder="email@dominio.com" name="email" value="${flash.oldFormData?.email}"></atlas-masked-input>
                        </atlas-col>
                        <atlas-col lg="4" md="2" sm="1">
                            <atlas-masked-input mask-alias="cell-phone" label="Celular" required="" size="md" name="mobilePhone" value="${flash.oldFormData?.mobilePhone}"></atlas-masked-input>
                        </atlas-col>
                        <atlas-col lg="4" md="2" sm="1">
                            <atlas-masked-input mask-alias="landline" label="Telefone" size="md" name="phone" value="${flash.oldFormData?.phone}"></atlas-masked-input>
                        </atlas-col>
                    </atlas-row>
                </atlas-grid>
                <div>
                    <p>Tipo de pessoa:</p>
                    <atlas-toggle name="personType">
                        <atlas-toggle-item value="${PersonType.NATURAL}" label="Pessoa física" ${flash.oldFormData?.personType == "NATURAL" ? "checked" : null}></atlas-toggle-item>
                        <atlas-toggle-item value="${PersonType.LEGAL}" label="Pessoa jurídica" ${flash.oldFormData?.personType == "LEGAL" ? "checked" : null}></atlas-toggle-item>
                    </atlas-toggle>
                </div>
                <atlas-grid>
                    <atlas-row>
                        <atlas-col lg="5" md="3" sm="1">
                            <atlas-postal-code label="CEP" required="" name="postalCode" size="md" value="${flash.oldFormData?.postalCode}"></atlas-postal-code>
                        </atlas-col>
                        <atlas-col lg="7" md="3" sm="1">
                            <atlas-input label="Rua/Avenida/Alameda" required="" placeholder="Insira o endereço" name="address" size="md" value="${flash.oldFormData?.address}"></atlas-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="5" md="3" sm="1">
                            <atlas-input label="Número" required="" placeholder="Insira o número" name="addressNumber" size="md" value="${flash.oldFormData?.addressNumber}"></atlas-input>
                        </atlas-col>
                        <atlas-col lg="7" md="3" sm="1">
                            <atlas-input label="Complemento" placeholder="Insira o complemento" name="addressComplement" size="md" value="${flash.oldFormData?.addressComplement}"></atlas-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="5" md="2" sm="1">
                            <atlas-input label="Bairro" required="" placeholder="Insira o bairro" name="district" size="md" value="${flash.oldFormData?.district}"></atlas-input>
                        </atlas-col>
                        <atlas-col lg="5" md="2" sm="1">
                            <atlas-input label="Cidade" required="" placeholder="Insira a cidade" name="city" size="md" value="${flash.oldFormData?.city}"></atlas-input>
                        </atlas-col>
                        <atlas-col lg="2" md="2" sm="1">
                            <atlas-input label="UF" required="" placeholder="" name="state" size="md" value="${flash.oldFormData?.state}"></atlas-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="6" md="3" sm="1">
                            <atlas-password-input label="Senha" required="" name="password" size="md"></atlas-password-input>
                        </atlas-col>
                        <atlas-col lg="6" md="3" sm="1">
                            <atlas-password-input label="Confirme sua senha" required="" name="passwordConfirm" size="md"></atlas-password-input>
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
                    <atlas-button description="Cancelar" slot="actions" theme="danger" href="/"></atlas-button>
                    <atlas-button submit description="Criar conta" slot="actions" theme="success"></atlas-button>
                </div>
                <div class="bottom-text">
                    <a href="${createLink(controller: 'login', action: 'auth')}">Já tem uma conta?</a>
                </div>
            </atlas-form>
        </atlas-panel>
    </body>
</html>