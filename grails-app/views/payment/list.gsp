<%@ page import="com.mini.asaas.utils.FormatUtils" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Lista de Cobranças</title>
</head>
<body>
<main>
  <h1>Lista de cobranças</h1>
  <div>
    <form action="${createLink(controller: 'payment', action: 'list')}" method="GET">
      <div>Filtros</div>
      <div>
        <input type="checkbox" name="deleted" value="true" id="deleted" ${Boolean.valueOf(params.deleted) == true ? raw("checked") : null}>
        <label for="deleted">Excluídos</label>
      </div>
      <button type="submit">Aplicar</button>
    </form>

    <table>
      <thead>
      <tr>
        <th>Pagador</th>
        <th>Valor</th>
        <th>Tipo de pagamento</th>
        <th>Status</th>
        <th>Data de vencimento</th>
      </tr>
      </thead>
      <tbody>
      <g:each var="payment" in="${paymentList}">
        <tr>
          <td>${payment.payer.name}</td>
          <td>${payment.value}</td>
          <td>${payment.billingType.getLabel()}</td>
          <td>${payment.status.getLabel()}</td>
          <td>${FormatUtils.formatDateToString(payment.dueDate)}</td>
          <td><a href="${createLink(controller: 'payment', action: 'show', id: payment.id)}">Visualizar</a></td>
        </tr>
      </g:each>
      </tbody>
    </table>
  </div>
</main>
</body>
</html>
