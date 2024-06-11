<atlas-sidebar slot="sidebar">
    <atlas-sidebar-menu slot="body">
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
                    href="${createLink(controller: 'payment', action: 'index')}"
                    ${ controllerName == 'payment' && actionName == 'index' ? 'active' : '' }
            ></atlas-sidebar-menu-item>
        </atlas-sidebar-menu-item>
    </atlas-sidebar-menu>
</atlas-sidebar>