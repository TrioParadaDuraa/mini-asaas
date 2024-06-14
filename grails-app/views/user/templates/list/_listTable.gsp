<atlas-table>
    <atlas-table-header slot="header">
        <atlas-table-col>
            Nome
        </atlas-table-col>
        <atlas-table-col>
            Email de acesso
        </atlas-table-col>
    </atlas-table-header>
    <atlas-table-body slot="body">
        <g:each var="user" in="${ userList }">
            <atlas-table-row>
                <atlas-table-col>
                    ${user.name}
                </atlas-table-col>
                <atlas-table-col>
                    ${user.username}
                </atlas-table-col>
            </atlas-table-row>
        </g:each>
    </atlas-table-body>
</atlas-table>