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