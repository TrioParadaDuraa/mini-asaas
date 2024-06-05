<atlas-filter id="js-payment-filter">
    <atlas-filter-form slot="simple-filter" method="GET" action="${createLink(controller: 'payment', action: 'list')}">
        <atlas-filter-group header="Deletados" name="deleted">
            <atlas-checkbox value="true">Sim</atlas-checkbox>
        </atlas-filter-group>
        <atlas-filter-group header="Status" name="status">
            <atlas-checkbox value="">Aguardando pagamento</atlas-checkbox>
            <atlas-checkbox value="">Vencida</atlas-checkbox>
            <atlas-checkbox value="">Cancelada</atlas-checkbox>
            <atlas-checkbox value="">Recebida em dinheiro</atlas-checkbox>
        </atlas-filter-group>
    </atlas-filter-form>
</atlas-filter>