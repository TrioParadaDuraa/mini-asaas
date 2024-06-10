<atlas-empty-state
        illustration="flow-money-coins"
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