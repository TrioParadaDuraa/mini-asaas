<%@ page import="com.mini.asaas.utils.FormatUtils ;com.mini.asaas.utils.enums.PaymentStatus; com.mini.asaas.payment.Payment; com.mini.asaas.utils.enums.BillingType" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Show</title>
  </head>
  <body>
      <form method="POST" action="${createLink(controller: 'payment', action: 'update')}">
          <input type="hidden" name="id" value="${payment.id}">
          <div>
              <label for="payerName">Pagador</label>
              <br>
              <input name="payerName" value="${payment.payer.name}" id="payerName" type="text" readonly>
          </div>
          <br>
          <div>
              <label for="billingType">Tipo de pagamento</label>
              <br>
              <input type="text" value="${payment.billingType.getLabel()}" readonly>
              <select name="billingType" id="billingType">
                  <g:each var="value" in="${BillingType.values()}">
                      <option value="${value}">${value.getLabel()}</option>
                  </g:each>
              </select>
          </div>
          <br>
          <div>
              <label for="value">Valor</label>
              <br>
              <input name="value" value="${payment.value}" id="value">
          </div>
          <br>
          <div>
              <label for="status">Status</label>
              <br>
              <input type="text" value="${payment.status.getLabel()}" readonly>
              <select name="status" id="status">
                  <g:each var="value" in="${PaymentStatus.values()}">
                      <option value="${value}">${value.getLabel()}</option>
                  </g:each>
              </select>
          </div>
          <br>
          <div>
              <label for="dueDate">Data de vencimento</label>
              <br>
              <input value="${FormatUtils.formatDateToString(payment.dueDate)}" id="dueDate" readonly>
              <input type="date" name="dueDate" value="${payment.dueDate}">
          </div>
          <br>
          <g:if test="${!payment.deleted}">
              <button type="submit">Salvar</button>
          </g:if>
      </form>
      <br>
      <g:if test="${payment.deleted}">
          <form method="POST" action="${createLink(controller: 'payment', action: 'restore', id: payment.id)}">
              <button type="submit">Restaurar</button>
          </form>
      </g:if>
      <g:else>
          <form method="POST" action="${createLink(controller: 'payment', action: 'delete', id: payment.id)}">
              <button type="submit">Excluir</button>
          </form>
      </g:else>
      <g:if test="${flash.message}">
          <section>
              <div>
                  <p>${flash.message}</p>
              </div>
          </section>
      </g:if>
  </body>
</html>