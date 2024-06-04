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
                <atlas-toolbar>
                    <atlas-button
                        icon="plus"
                        description="Adicionar cobrança"
                        href="${createLink(controller: 'payment', action: 'index')}"
                        slot="actions"
                    ></atlas-button>
                </atlas-toolbar>
                <atlas-table has-actions>
                    <atlas-table-header slot="header">
                        <atlas-table-col>
                            Pagador
                        </atlas-table-col>
                        <atlas-table-col>
                            Valor
                        </atlas-table-col>
                        <atlas-table-col>
                            Status
                        </atlas-table-col>
                    </atlas-table-header>
                    <atlas-table-body slot="body">
                        <g:each var="payment" in="${ paymentList }">
                            <atlas-table-row href="${createLink(controller: 'payment', action: 'show', id: payment.id)}">
                                <atlas-table-col>
                                    ${payment.payer.name}
                                </atlas-table-col>
                                <atlas-table-col>
                                    ${payment.value}
                                </atlas-table-col>
                                <atlas-table-col>
                                    ${payment.status.getLabel()}
                                </atlas-table-col>

                                <atlas-button-group slot="actions" group-all>
                                    <atlas-icon-button
                                        icon="eye"
                                        theme="primary"
                                        description="Visualizar cobrança"
                                    ></atlas-icon-button>
                                </atlas-button-group>
                            </atlas-table-row>
                        </g:each>
                    </atlas-table-body>
                </atlas-table>
            </g:if>
            <g:else>
                <atlas-empty-state
                    illustration="flow-money-coins"
                    header="Sem cobranças cadastradas"
                >
                    Aqui você pode cadastrar uma cobrança
                    <atlas-button
                        icon="plus"
                        description="Adicionar cobrança"
                        href="${createLink(controller: 'payment', action: 'index')}"
                        slot="button"
                    ></atlas-button>
                </atlas-empty-state>
            </g:else>
        </atlas-panel>
    </body>
</html>
