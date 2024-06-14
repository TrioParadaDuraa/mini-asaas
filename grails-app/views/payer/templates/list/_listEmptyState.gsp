<atlas-empty-state
        illustration="credit-card-search"
        header="Sem clientes cadastrados"
>
    Aqui você pode cadastrar um novo pagador
    <atlas-button
            icon="plus"
            description="Adicionar pagador"
            href="${createLink(controller: 'payer', action: 'index')}"
            slot="button"
    ></atlas-button>
</atlas-empty-state>