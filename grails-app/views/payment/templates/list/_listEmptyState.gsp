<atlas-empty-state
        illustration="flow-money-coins"
        header="Sem cobranças cadastradas"
>
    Aqui você pode cadastrar uma cobrança
    <atlas-button
            icon="plus"
            description="Adicionar cobrança"
            href="${createLink(controller: 'payment', action: 'index')}"
            slot="button"
    ></atlas-button>
</atlas-empty-state>