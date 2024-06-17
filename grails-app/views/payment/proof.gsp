<%@ page import="com.mini.asaas.utils.FormatUtils; com.mini.asaas.utils.enums.PaymentStatus" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="main">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Comprovante de pagamento</title>
    </head>
    <body title="Comprovante de pagamento">
        <atlas-panel>
            <atlas-grid>
                <atlas-row>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Nome do pagador:" required="" size="md" value="${payment.payer.name}" disabled=""></atlas-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-masked-input mask-alias="cpf-cnpj" label="CPF/CNPJ:" required="" size="md" value="${payment.payer.cpfCnpj}" disabled=""></atlas-masked-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Tipo de pagamento:" required="" size="md" value="${payment.billingType.getLabel()}" disabled=""></atlas-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Valor da cobrança:" required="" value="R$ ${FormatUtils.formatBigDecimal(payment.value)}" disabled=""></atlas-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Status da cobrança:" required="" value="${payment.status.getLabel()}" disabled=""></atlas-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Data de vencimento:" required="" value="${FormatUtils.formatDateToString(payment.dueDate)}" disabled=""></atlas-input>
                    </atlas-col>
                </atlas-row>
            </atlas-grid>
        </atlas-panel>
    </body>
</html>