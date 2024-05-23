<%@ page import="com.mini.asaas.utils.Utils" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Show</title>
  </head>
  <body>
      <div>
          <label for="customerName">Cliente</label>
          <br>
          <input name="customerName" value="${payment.customer.name}" id="customerName" type="text" readonly>
      </div>
      <br>
      <div>
          <label for="payerName">Pagador</label>
          <br>
          <input name="payerName" value="${payment.payer.name}" id="payerName" type="text" readonly>
      </div>
      <br>
      <div>
          <label for="paymentType">Tipo de pagamento</label>
          <br>
          <input name="paymentType" value="${payment.paymentType.getLabel()}" id="paymentType" readonly>
      </div>
      <br>
      <div>
          <label for="value">Valor</label>
          <br>
          <input name="value" value="${payment.value}" id="value" readonly>
      </div>
      <br>
      <div>
          <label for="status">Status</label>
          <br>
          <input name="status" value="${payment.status.getLabel()}" id="status" readonly>
      </div>
      <br>
      <div>
          <label for="dueDate">Data de vencimento</label>
          <br>
          <input name="dueDate" value="${Utils.formatDateToString(payment.dueDate)}" id="dueDate" readonly>
      </div>
  </body>
</html>