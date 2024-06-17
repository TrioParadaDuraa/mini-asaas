<%@ page import="com.mini.asaas.utils.message.MessageType" %>
<div class="error-message hide ${(flash.type == MessageType.ERROR ) ? 'has-errors' : ''}">
    <div class="alert alert-danger">
        <g:if test="${flash.message}">
            ${flash.message}
        </g:if>
        <g:if test="${flash.errors}">
            <ul>
                <g:each var="error" in="${flash.errors}">
                    <li>${error.defaultMessage}</li>
                </g:each>
            </ul>
        </g:if>
    </div>
</div>
