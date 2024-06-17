<atlas-navbar slot="navbar">
    <a href="${createLink(controller: 'dashboard', action: 'index')}"><atlas-icon name="home" size="3x"></atlas-icon></a>
    <div class="navbar-user js-navbar-user">
        <atlas-icon-button icon="bell" class="js-notification-bell-button" size="3x" data-atlas-dropdown="notification-dropdown" hoverable="" badge-number="0" tooltip-placement="bottom" tooltip-trigger="hover focus" aria-expanded="false">
        </atlas-icon-button>
        <atlas-dropdown id="notification-dropdown" placement="bottom-end" class="js-notification-dropdown" loading-text="Estamos carregando as notificações" header="Notificações" no-gap="" auto-close="" auto-close-trigger="outside" tabindex="-1">
            <div class="js-notification-container">

            </div>
        </atlas-dropdown>

        <atlas-avatar data-atlas-dropdown="user-options" image="" user-name="Atlas user" show-icon-mobile="" show-carret="" hoverable=""></atlas-avatar>
        <atlas-dropdown id="user-options" class="js-atlas-user-menu" header="<sec:ifLoggedIn><sec:username/></sec:ifLoggedIn>" auto-close="" auto-close-triger="outside" tabindex="-1">
            <atlas-dropdown-item icon="cog" theme="secondary" href="${createLink(controller: 'customer', action: 'show')}">Minha conta</atlas-dropdown-item>
            <form action="${createLink(controller: 'logout', action: 'index')}" method="POST">
                <button type="submit" class="logout-button">Sair</button>
            </form>
        </atlas-dropdown>
    </div>
</atlas-navbar>