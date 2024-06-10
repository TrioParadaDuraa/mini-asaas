<%@ page import="com.mini.asaas.utils.FormatUtils" %>
<atlas-table has-actions>
    <atlas-table-header slot="header">
        <atlas-table-col>
            Nome do Pagador
        </atlas-table-col>
        <atlas-table-col>
            CPF/CNPJ
        </atlas-table-col>
    </atlas-table-header>
    <atlas-table-body slot="body">
        <g:each var="payer" in="${ payerList }">
            <atlas-table-row href="${createLink(controller: 'payer', action: 'show', id: payer.id)}">
                <atlas-table-col>
                    ${payer.name}
                </atlas-table-col>
                <atlas-table-col>
                    ${payer.cpfCnpj}
                </atlas-table-col>

                <atlas-button-group slot="actions" group-all>
                    <atlas-icon-button
                            icon="eye"
                            theme="primary"
                            description="Visualizar pagador"
                    ></atlas-icon-button>
                </atlas-button-group>
            </atlas-table-row>
        </g:each>
    </atlas-table-body>
</atlas-table>