<atlas-navbar slot="navbar">
    <a href="${createLink(controller: 'dashboard', action: 'index')}"><atlas-icon name="home" size="3x"></atlas-icon></a>
    <div class="navbar-user">
        <atlas-icon-button icon="bell" class="js-notification-bell-button" size="3x" data-atlas-dropdown="test-dropdown" hoverable="" badge-number="0" tooltip-placement="bottom" tooltip-trigger="hover focus" aria-expanded="false">
        </atlas-icon-button>
        <atlas-dropdown id="test-dropdown" placement="bottom-end" class="js-notification-dropdown" loading-text="Estamos carregando as notificações" header="Notificações" no-gap="" auto-close="" auto-close-trigger="outside" tabindex="-1">
            <atlas-notification-card></atlas-notification-card>
            <atlas-notification-card></atlas-notification-card>
        </atlas-dropdown>

        <atlas-avatar data-atlas-dropdown="user-options" image="" user-name="Atlas user" show-icon-mobile="" show-carret="" hoverable=""></atlas-avatar>
        <atlas-dropdown id="user-options" class="js-atlas-user-menu" header="Email do usuario :)" auto-close="" auto-close-triger="outside" tabindex="-1">
            <atlas-dropdown-item icon="cog" theme="secondary" href="/customer/show/">Minha conta</atlas-dropdown-item>
        </atlas-dropdown>
    </div>
</atlas-navbar>