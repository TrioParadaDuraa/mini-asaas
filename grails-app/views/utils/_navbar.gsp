<atlas-navbar>
    <div class="navbar-user">
        <div>
            <atlas-icon name="bell" size="3x" data-atlas-dropdown="test-dropdwon"></atlas-icon>
            <atlas-dropdown id="test-dropdown">
                <atlas-dropdown-item>item 1</atlas-dropdown-item>
                <atlas-dropdown-item>item 2</atlas-dropdown-item>
            </atlas-dropdown>
        </div>
        <atlas-avatar data-atlas-dropdown="user-options" image="" user-name="Atlas user" show-icon-mobile="" show-carret="" hoverable=""></atlas-avatar>
        <atlas-dropdown id="user-options">
            <atlas-dropdown-item icon="cog" theme="secondary">Minha conta</atlas-dropdown-item>
        </atlas-dropdown>
    </div>
</atlas-navbar>