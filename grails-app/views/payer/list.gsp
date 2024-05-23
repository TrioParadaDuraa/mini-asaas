<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Pagadores</title>
</head>
<body>
    <main>
        <h1>Lista de pagadores</h1>        
        <div>
            <form action="${createLink(controller: 'payer', action: 'list')}" method="GET">
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
                        <th>Nome</th>
                        <th>CPF/CNPJ</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each var="payer" in="${payerList}">
                        <tr>
                            <td>${payer.name}</td>
                            <td>${payer.cpfCnpj}</td>
                            <td><a href="${createLink(controller: 'payer', action: 'show', id: payer.id)}">Visualizar</a></td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
        </div>
    </main>
</body>
</html>
