<div class="box-header">
    <ul class="nav-tabs">
        <li>
            <atlas-button
                description="Meus dados"
                href="${createLink(controller: 'customer', action: 'show')}"
                icon="user"
                type="${ controllerName == 'customer' && actionName == 'show' ? 'filled' : 'ghost' }"
            >
            </atlas-button>
        </li>
        <li>
            <atlas-button
                description="Atualizar dados"
                href="${createLink(controller: 'customer', action: 'edit')}"
                icon="pencil"
                type="${ controllerName == 'customer' && actionName == 'edit' ? 'filled' : 'ghost' }"
            ></atlas-button>
        </li>
        <li>
            <atlas-button
                description="Redefinir senha"
                href=""
                icon="spanner"
                type="${ controllerName == 'user' && actionName == 'edit' ? 'filled' : 'ghost' }"
            ></atlas-button>
        </li>
        <li>
            <atlas-button
                description="Usuários"
                href="${createLink(controller: 'user', action: 'list')}"
                icon="users"
                type="${ controllerName == 'user' && actionName == 'list' ? 'filled' : 'ghost' }"
            ></atlas-button>
        </li>
    </ul>
</div>