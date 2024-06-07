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
                    href="${createLink(controller: 'customer', action: 'show')}"
                    ${ controllerName == 'customer' && actionName == 'show' ? 'active' : '' }
            ></atlas-sidebar-menu-item>

            <atlas-sidebar-menu-item
                    icon="pencil"
                    value=""
                    text="Atualizar dados"
                    href="${createLink(controller: 'customer', action: 'edit')}"
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
                    href="${createLink(controller: 'payment', action: 'index')}"
                    ${ controllerName == 'payment' && actionName == 'index' ? 'active' : '' }
            ></atlas-sidebar-menu-item>
        </atlas-sidebar-menu-item>

        <atlas-sidebar-menu-item
                icon="address-book"
                value=""
                text="Pagadores"
                href="">
            <atlas-sidebar-menu-item
                    icon="hand-shake"
                    value=""
                    text="Meus pagadores"
                    href="${createLink(controller: 'payer', action: 'list')}"
            ></atlas-sidebar-menu-item>

            <atlas-sidebar-menu-item
                    icon="plus"
                    value=""
                    text="Cadastrar pagador"
                    href="${createLink(controller: 'payer', action: 'index')}"
            ></atlas-sidebar-menu-item>
        </atlas-sidebar-menu-item>
    </atlas-sidebar-menu>
</atlas-sidebar>