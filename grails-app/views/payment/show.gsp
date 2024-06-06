<%@ page import="com.mini.asaas.utils.FormatUtils; com.mini.asaas.utils.enums.PaymentStatus; com.mini.asaas.payment.Payment; com.mini.asaas.utils.enums.BillingType; com.mini.asaas.utils.Utils" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="main">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Visualização de cobrança</title>
    </head>
    <body>
        <atlas-panel header="Dados da cobrança">
            <atlas-grid>
                <atlas-row>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Nome do pagador:" required="" name="payerName" size="md" value="${payment.payer.name}" disabled=""></atlas-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-masked-input mask-alias="cpf-cnpj" label="CPF/CNPJ:" required="" name="cpfCnpj" size="md" value="${payment.payer.cpfCnpj}" disabled=""></atlas-masked-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-masked-input mask-alias="email" label="Email:" required="" name="email" size="md" value="${payment.payer.email}" disabled=""></atlas-masked-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-masked-input mask-alias="cell-phone" label="Celular:" required="" name="mobilePhone" size="md" value="${payment.payer.mobilePhone}" disabled=""></atlas-masked-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Tipo de pagamento:" required="" name="billingType" size="md" value="${payment.billingType.getLabel()}" disabled=""></atlas-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Valor da cobrança:" required="" name="value" value="R$ ${Utils.formatBigDecimal(payment.value)}" disabled=""></atlas-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Status da cobrança:" required="" name="status" value="${payment.status.getLabel()}" disabled=""></atlas-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Data de vencimento:" required="" name="dueDate" value="${FormatUtils.formatDateToString(payment.dueDate)}" disabled=""></atlas-input>
                    </atlas-col>
                </atlas-row>
            </atlas-grid>
            <g:if test="${payment.deleted}">
                <atlas-button description="Restaurar" slot="actions" href="${createLink(controller: 'payment', action: 'restore', id: payment.id)}"></atlas-button>
            </g:if>
            <g:else>
                <atlas-button description="Excluir" slot="actions" theme="danger" href="${createLink(controller: 'payment', action: 'delete', id: payment.id)}"></atlas-button>
            </g:else>
        </atlas-panel>
    </body>
</html>