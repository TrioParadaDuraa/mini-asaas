<%@ page import="com.mini.asaas.utils.FormatUtils" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta name="layout" content="main">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lista de Cobranças</title>
    </head>
    <body>
        <atlas-panel>
            <g:if test="${ paymentList }">
                <g:render template="templates/list/listFilter"/>
                <g:render template="templates/list/listToolbar"/>
                <g:render template="templates/list/listTable"/>
            </g:if>
            <g:else>
                <g:render template="templates/list/listEmptyState"/>
            </g:else>
        </atlas-panel>
    </body>
</html>
