<div class="dropdown-filter">
    <button class="filter-button">Filtros</button>
    <div class="dropdown-filter-content">
        <form action="${createLink(controller: 'payment', action: 'list')}" method="GET" class="filter-form">
            <div>
                <input type="checkbox" name="deleted" value="true" id="deleted" ${Boolean.valueOf(params.deleted) == true ? raw("checked") : null}>
                <label for="deleted">Excluidos</label>
            </div>
            <button type="submit" class="filter-button">Aplicar</button>
        </form>
    </div>
</div>