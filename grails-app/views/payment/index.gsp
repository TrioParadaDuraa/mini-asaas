<%@ page import="com.mini.asaas.utils.enums.PaymentType" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Register</title>
  </head>
  <body>
      <form method="POST" action="${createLink(controller: "payment", action: "save")}">
        <div>
            <label>Tipo de pagamento</label>
            <br>
            <select name="paymentType" id="paymentType">
                <g:each var="value" in="${PaymentType.values()}">
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
        <button type="submit">Salvar</button>
      </form>
  </body>
</html>