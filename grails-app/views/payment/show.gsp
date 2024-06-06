<%@ page import="com.mini.asaas.utils.FormatUtils; com.mini.asaas.utils.Utils; com.mini.asaas.utils.enums.PaymentStatus" %>
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
                        <atlas-input label="Nome do pagador:" required="" size="md" value="${payment.payer.name}" disabled=""></atlas-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-masked-input mask-alias="cpf-cnpj" label="CPF/CNPJ:" required="" size="md" value="${payment.payer.cpfCnpj}" disabled=""></atlas-masked-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-masked-input mask-alias="email" label="Email:" required="" size="md" value="${payment.payer.email}" disabled=""></atlas-masked-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-masked-input mask-alias="cell-phone" label="Celular:" required="" size="md" value="${payment.payer.mobilePhone}" disabled=""></atlas-masked-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Tipo de pagamento:" required="" size="md" value="${payment.billingType.getLabel()}" disabled=""></atlas-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Valor da cobrança:" required="" value="R$ ${Utils.formatBigDecimal(payment.value)}" disabled=""></atlas-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Status da cobrança:" required="" value="${payment.status.getLabel()}" disabled=""></atlas-input>
                    </atlas-col>
                    <atlas-col lg="6" md="3" sm="1">
                        <atlas-input label="Data de vencimento:" required="" value="${FormatUtils.formatDateToString(payment.dueDate)}" disabled=""></atlas-input>
                    </atlas-col>
                </atlas-row>
                <atlas-row>
                    <atlas-col lg="12" md="6" sm="1">
                        <div style="display: flex; align-items: center; gap: 10px">
                            <atlas-icon name="pencil" size="3x"></atlas-icon>
                            <h4>Atualizar status da cobrança:</h4>
                        </div>
                    </atlas-col>
                </atlas-row>
            </atlas-grid>
            <g:if test="${payment.deleted}">
                <atlas-button description="Restaurar" slot="actions" href="${createLink(controller: 'payment', action: 'restore', id: payment.id)}"></atlas-button>
            </g:if>
            <g:else>
                <atlas-button description="Excluir" slot="actions" theme="danger" href="${createLink(controller: 'payment', action: 'delete', id: payment.id)}"></atlas-button>
            </g:else>
            <div style="display: flex; justify-content: start; gap: 1.875rem">
                <atlas-button description="Aguardando pagamento" href="${createLink(controller: 'payment', action: 'updateToAwaitingPayment', id: payment.id)}"></atlas-button>
                <atlas-button description="Recebida" href="${createLink(controller: 'payment', action: 'updateToReceived', id: payment.id)}"></atlas-button>
                <atlas-button description="Recebido em dinheiro" theme="success" href="${createLink(controller: 'payment', action: 'updateToReceivedInCash', id: payment.id)}"></atlas-button>
                <atlas-button description="Cancelada" theme="danger" href="${createLink(controller: 'payment', action: 'updateToCanceled', id: payment.id)}"></atlas-button>
            </div>
            <g:if test="${flash.message}">
                <section>
                    <div>
                        <p>${flash.message}</p>
                    </div>
                </section>
            </g:if>
        </atlas-panel>
    </body>
</html>