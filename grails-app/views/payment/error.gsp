<!doctype html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="error">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cobrança não encontrada</title>
    </head>
    <body>
        <atlas-empty-state
            illustration="flow-money-coins"
            header="Não foi possível carregar os dados da cobrança"
        >
            Aqui você pode retornar para as cobranças.
            <atlas-button
                description="Acessar cobranças"
                href="${createLink(controller: 'payment', action: 'list')}"
                slot="button"
            ></atlas-button>
        </atlas-empty-state>
    </body>
</html>