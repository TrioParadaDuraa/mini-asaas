<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="${createLink(controller: "customer", action: "save")}">
        <div>
            <label>Nome</label>
            <br>
            <input type="text" name="name" value="${customer.name}" readonly>
        </div>
        <div>
            <label>Email</label>
            <br>
            <input type="email" name="email" value="${customer.email}" readonly>
        </div>
        <br>
        <div>
            <label>Tipo de pessoa</label>
            <br>
            <input type="text" name="personType" value="${customer.personType.getLabel()}" readonly>
        </div>
    </form>
</body>
</html>