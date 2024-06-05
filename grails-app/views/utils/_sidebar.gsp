<atlas-sidebar slot="sidebar">
    <atlas-sidebar-menu slot="body">
        <atlas-sidebar-menu-item
                icon="cog"
                value=""
                text="Minha conta"
                ${ controllerName == 'customer' ? 'active' : '' }
        >
            <atlas-sidebar-menu-item
                    icon="user"
                    value=""
                    text="Meus dados"
                    href="${createLink(controller: 'customer', action: 'show', id: 2)}"
                    ${ controllerName == 'customer' && actionName == 'show' ? 'active' : '' }
            ></atlas-sidebar-menu-item>

            <atlas-sidebar-menu-item
                    icon="pencil"
                    value=""
                    text="Atualizar dados"
                    href="${createLink(controller: 'customer', action: 'edit', id: 2)}"
                    ${ controllerName == 'customer' && actionName == 'edit' ? 'active' : '' }
            ></atlas-sidebar-menu-item>

            <atlas-sidebar-menu-item
                    icon="spanner"
                    value=""
                    text="Redefinir senha"
                    href=""
            ></atlas-sidebar-menu-item>
        </atlas-sidebar-menu-item>
        <atlas-sidebar-menu-item
                icon="money"
                value=""
                text="Cobranças"
                ${ controllerName == 'payment' ? 'active' : '' }
        >
            <atlas-sidebar-menu-item
                    icon="dollar-sign"
                    value=""
                    text="Minhas cobranças"
                    href="${createLink(controller: 'payment', action: 'list')}"
                    ${ controllerName == 'payment' && actionName == 'list' ? 'active' : '' }
            ></atlas-sidebar-menu-item>

            <atlas-sidebar-menu-item
                    icon="plus"
                    value=""
                    text="Criar cobrança"
                    href="${createLink(controller: 'payment', action: 'index', id: 2)}"
                    ${ controllerName == 'payment' && actionName == 'index' ? 'active' : '' }
            ></atlas-sidebar-menu-item>
        </atlas-sidebar-menu-item>
    </atlas-sidebar-menu>
</atlas-sidebar>