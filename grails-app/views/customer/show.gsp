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
            <label for="name">Nome</label>
            <br>
            <input type="text" id="name" name="name" value="${customer.name}" readonly>
        </div>
        <div>
            <label for="name">Email</label>
            <br>
            <input type="text" id="email" name="email" value="${customer.email}" readonly>
        </div>
        <br>
        <div>
            <label for="personType">Tipo de pessoa</label>
            <br>
            <input type="text" name="personType" id="personType" value="${customer.personType.getLabel()}" readonly>
        </div>
    </form>
</body>
</html>