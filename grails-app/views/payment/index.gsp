<%@ page import="com.mini.asaas.utils.enums.PaymentStatus; com.mini.asaas.payment.Payment; com.mini.asaas.utils.enums.BillingType" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="main">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Payment Register</title>
    </head>
    <body>
        <atlas-panel>
            <atlas-form method="POST" action="${createLink(controller: 'payment', action: 'save')}">
                <atlas-grid>
                    <atlas-row>
                        <atlas-col lg="12" md="6" sm="2">

                        </atlas-col>
                    </atlas-row>
                </atlas-grid>
            </atlas-form>
        </atlas-panel>
        <form method="POST" action="${createLink(controller: 'payment', action: 'save')}">
            <div>
                <label>Selecione um pagador</label>
                <br>
                <g:select
                        name="payerId"
                        from="${payerList}"
                        optionKey="id"
                        optionValue="name"
                        noSelection="['':'Selecione um pagador']"
                />
            </div>
            <br>
            <div>
                <label>Tipo de pagamento</label>
                <br>
                <select name="billingType" id="billingType">
                    <g:each var="value" in="${BillingType.values()}">
                        <option value="${value}">${value.getLabel()}</option>
                    </g:each>
                </select>
            </div>
            <br>
            <div>
                <label>Valor da cobrança: </label>
                <br>
                <input type="number" name="value" step="any" value="${params.value}">
            </div>
            <br>
            <div>
                <label>Data de vencimento: </label>
                <br>
                <input type="date" name="dueDate" value="${params.dueDate}">
            </div>
            <br>
            <div>
                <label>Status da cobrança:</label>
                <br>
                <select name="status" id="status">
                    <g:each var="value" in="${PaymentStatus.values()}">
                        <option value="${value}">${value.getLabel()}</option>
                    </g:each>
                </select>
            </div>
            <br>
            <button type="submit">Salvar</button>
        </form>
        <g:if test="${flash.message}">
            <section>
                <div>
                    <p>${flash.message}</p>
                </div>
            </section>
        </g:if>
    </body>
</html>