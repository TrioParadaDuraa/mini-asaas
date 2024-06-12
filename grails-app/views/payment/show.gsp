<%@ page import="com.mini.asaas.utils.FormatUtils; com.mini.asaas.utils.enums.PaymentStatus" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="main">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Visualização de cobrança</title>
    </head>
    <body title="Dados da cobrança">
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
                        <atlas-input label="Valor da cobrança:" required="" value="R$ ${FormatUtils.formatBigDecimal(payment.value)}" disabled=""></atlas-input>
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
                        <div class="edit-payment-card-header">
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
            <form method="POST" action="${createLink(controller: 'payment', action: 'updateStatus', id: payment.id)}">
                <div class="edit-payment-card">
                    <g:if test="${payment.status == PaymentStatus.AWAITING_PAYMENT}">
                        <div class="edit-payment-card-item">
                            <label for="received">Recebida</label>
                            <input type="radio" id="received" name="status" value="${PaymentStatus.RECEIVED}">
                        </div>
                        <div class="edit-payment-card-item">
                            <label for="received_in_cash">Recebida em dinheiro</label>
                            <input type="radio" id="received_in_cash" name="status" value="${PaymentStatus.RECEIVED_IN_CASH}">
                        </div>
                    </g:if>
                    <g:else>
                        <div class="edit-payment-card-item">
                            <label for="awaiting_payment">Aguardando pagamento</label>
                            <input type="radio" id="awaiting_payment" name="status" value="${PaymentStatus.AWAITING_PAYMENT}">
                        </div>
                    </g:else>
                </div>
                <button class="edit-payment-form-button" type="submit">Salvar</button>
            </form>
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