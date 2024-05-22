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
        <label>Pagador</label>
        <br>
      </div>
      <br>
      <div>
        <label>Tipo de pagamento</label>
        <br>
      </div>
      <br>
      <div>
        <label>Valor da cobrança: </label>
        <br>
        <input type="number" name="value" step= "any" value="${params.value}">
      </div>
      <br>
      <div>
        <label>Data de vencimento: </label>
        <br>
        <input type="date" name="dueDate" value="${params.dueDate}">
      </div>
    </form>
  </body>
</html>