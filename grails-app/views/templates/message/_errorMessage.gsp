<div class="error-message hide ${(flash.errors) ? 'has-errors' : ''}">
    <div class="alert alert-danger">
        <ul>
            <g:each var="error" in="${flash.errors}">
                <li>${error.defaultMessage}</li>
            </g:each>
        </ul>
    </div>
</div>
