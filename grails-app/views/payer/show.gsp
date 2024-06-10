<%@ page import="com.mini.asaas.utils.base.PersonType" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta name="layout" content="main">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visualizar pagador</title>
</head>
<body>
<form method="POST" action="${createLink(controller: 'payer', action: 'update')}">
    <input type="hidden" name="id" value="${payer.id}">
    <div>
        <label for="name">Nome Completo</label>
        <br>
        <input name="name" value="${payer.name}" id="name" type="text" readonly>
    </div>
    <br>
    <div>
        <label for="personType">Tipo de pessoa</label>
        <br>
        <input type="text" value="${payer.personType.getLabel()}" readonly>
        <select name="personType" id="personType">
            <g:each var="value" in="${PersonType.values()}">
                <option value="${value}">${value.getLabel()}</option>
            </g:each>
        </select>
    </div>
    <br>
    <div>
        <label for="cpfCnpj">CPF/CNPJ</label>
        <br>
        <input name="cpfCnpj" value="${payer.cpfCnpj}" id="cpfCnpj" type="text" maxlength="14">
    </div>
    <br>
    <div>
        <label for="email">Email</label>
        <br>
        <input type="email" name="email" value="${payer.email}" id="email">
    </div>
    <br>
    <div>
        <label for="phone">Telefone</label>
        <br>
        <input type="tel" name="phone" value="${payer.phone}" id="phone" maxlength="10">
    </div>
    <br>
    <div>
        <label for="mobilePhone">Celular</label>
        <br>
        <input name="mobilePhone" value="${payer.mobilePhone}" id="mobilePhone" type="tel" maxlength="11">
    </div>
    <g:if test="${flash.errors?.hasFieldErrors('mobilePhone')}">
        <div>Celular inválido</div>
    </g:if>


    <div>
        <label for="postalCode">CEP</label>
        <br>
        <input name="postalCode" value="${payer.postalCode}" id="postalCode" type="text" maxlength="8">
    </div>
    <div>
        <label for="address">Endereço</label>
        <br>
        <input name="address" value="${payer.address}" id="address" type="text">
    </div>
    <g:if test="${flash.errors?.hasFieldErrors('address')}">
        <div>Endereço inválido</div>
    </g:if>


    <div>
        <label for="addressNumber">Número</label>
        <br>
        <input name="addressNumber" value="${payer.addressNumber}" id="addressNumber" type="text">
    </div>
    <g:if test="${flash.errors?.hasFieldErrors('addressNumber')}">
        <div>Número inválido</div>
    </g:if>


    <div>
        <label for="addressComplement">Complemento</label>
        <br>
        <input name="addressComplement" value="${payer.addressComplement}" id="addressComplement" type="text">
    </div>


    <div>
        <label for="district">Bairro</label>
        <br>
        <input name="district" value="${payer.district}" id="district" type="text">
    </div>
    <g:if test="${flash.errors?.hasFieldErrors('district')}">
        <div>Bairro inválido</div>
    </g:if>


    <div>
        <label for="city">Cidade</label>
        <br>
        <input name="city" value="${payer.city}" id="city" type="text">
    </div>
    <g:if test="${flash.errors?.hasFieldErrors('city')}">
        <div>Cidade inválida</div>
    </g:if>


    <div>
        <label for="state">Estado</label>
        <br>
        <input name="state" value="${payer.state}" id="state" type="text">
    </div>

    <g:if test="${!payer.deleted}">
        <button type="submit">Salvar</button>
    </g:if>
</form>

<g:if test="${payer.deleted}">
    <form method="POST" action="${createLink(controller: 'payer', action: 'restore', id: payer.id)}">
        <button type="submit">Restaurar</button>
    </form>
</g:if>
<g:else>
    <form method="POST" action="${createLink(controller: 'payer', action: 'delete', id: payer.id)}">
        <button type="submit">Excluir</button>
    </form>
</g:else>
<g:if test="${flash.message}">
    <section>
        <div>
            <p>${flash.message}</p>
        </div>
    </section>
</g:if>
</body>
</html>
