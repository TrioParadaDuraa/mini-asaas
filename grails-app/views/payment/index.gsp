<%@ page import="com.mini.asaas.utils.enums.PaymentStatus; com.mini.asaas.payment.Payment; com.mini.asaas.utils.enums.BillingType" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="main">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Criar cobrança</title>
        <asset:javascript src="paymentInputUpdate.js"/>
        <asset:javascript src="errorMessage.js"/>
    </head>
    <body title="Cadastro de cobrança">
        <atlas-panel>
            <g:render template="/templates/message/errorMessage"/>
            <atlas-form method="POST" action="${createLink(controller: 'payment', action: 'save')}">
                <atlas-grid>
                    <atlas-row>
                        <atlas-col lg="3" md="2" sm="1">
                            <atlas-select label="Selecione um pagador:" id="js-payer-select" required="" name="payerId" placeholder="Selecione um pagador">
                                <g:each var="payer" in="${payerList}">
                                    <atlas-option
                                        label="${payer.name}"
                                        value="${payer.id}"
                                        data-custom-cpfCnpj="${payer.cpfCnpj}"
                                        data-custom-email="${payer.email}"
                                        data-custom-mobilePhone="${payer.mobilePhone}"
                                    ></atlas-option>
                                </g:each>
                            </atlas-select>
                        </atlas-col>
                        <atlas-col lg="3" md="2" sm="1">
                            <atlas-masked-input mask-alias="cpf-cnpj" label="CPF/CNPJ" size="md" name="payerCpfCnpj" id="js-payer-cpf-cnpj" value="" required="" disabled=""></atlas-masked-input>
                        </atlas-col>
                        <atlas-col lg="3" md="1" sm="1">
                            <atlas-masked-input mask-alias="email" label="Email" size="md" name="email" id="js-payer-email" value="" required="" disabled=""></atlas-masked-input>
                        </atlas-col>
                        <atlas-col lg="3" md="1" sm="1">
                            <atlas-masked-input mask-alias="cell-phone" label="Celular" size="md" name="mobilePhone" id="js-payer-mobile-phone" value="" required="" disabled=""></atlas-masked-input>
                        </atlas-col>
                    </atlas-row>
                    <atlas-row>
                        <atlas-col lg="2" md="2" sm="1">
                            <atlas-money label="Valor da cobrança:" required="" name="value" value="${params.value}"></atlas-money>
                        </atlas-col>
                        <atlas-col lg="2" md="2" sm="1">
                            <atlas-datepicker label="Data de vencimento:" required="" name="dueDate" value="${params.dueDate}"></atlas-datepicker>
                        </atlas-col>
                    </atlas-row>
                </atlas-grid>
                <div>
                    <p>Tipo de pagamento:</p>
                    <atlas-toggle name="billingType" required="">
                        <atlas-toggle-item value="${BillingType.BANK_SLIP}" label="Boleto bancário"></atlas-toggle-item>
                        <atlas-toggle-item value="${BillingType.PIX}" label="PIX"></atlas-toggle-item>
                        <atlas-toggle-item value="${BillingType.CREDIT_CARD}" label="Cartão de crédito"></atlas-toggle-item>
                    </atlas-toggle>
                    <p>Status da cobrança:</p>
                    <atlas-toggle name="status" required="">
                        <atlas-toggle-item value="${PaymentStatus.AWAITING_PAYMENT}" label="Aguardando pagamento"></atlas-toggle-item>
                        <atlas-toggle-item value="${PaymentStatus.RECEIVED}" label="Recebida"></atlas-toggle-item>
                        <atlas-toggle-item value="${PaymentStatus.RECEIVED_IN_CASH}" label="Recebida em dinheiro"></atlas-toggle-item>
                    </atlas-toggle>
                </div>
                <br>
                <div class="bottom-buttons">
                    <atlas-button description="Cancelar" slot="actions" theme="danger"></atlas-button>
                    <atlas-button submit description="Criar cobrança" slot="actions" theme="success"></atlas-button>
                </div>
            </atlas-form>
        </atlas-panel>
    </body>
</html>