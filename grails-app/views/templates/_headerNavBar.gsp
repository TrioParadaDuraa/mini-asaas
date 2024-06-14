<div class="box-header">
    <ul class="nav-tabs">
        <li>
            <a href="${createLink(controller: 'customer', action: 'show')}"><atlas-icon name="user" size="2x"></atlas-icon> Meus dados</a>
        </li>
        <li>
            <a href="${createLink(controller: 'customer', action: 'edit')}"><atlas-icon name="pencil" size="2x"></atlas-icon> Atualizar dados</a>
        </li>
        <li>
            <a href=""><atlas-icon name="spanner" size="2x"></atlas-icon> Redefinir senha</a>
        </li>
        <li>
            <a href="${createLink(controller: 'user', action: 'list')}"><atlas-icon name="users" size="2x"></atlas-icon> Usuários</a>
        </li>
    </ul>
</div>