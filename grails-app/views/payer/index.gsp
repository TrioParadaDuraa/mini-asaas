<%@ page import="com.mini.asaas.utils.base.PersonType" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Pagador</title>
</head>
<body>
    <form action="${createLink(controller: 'payer', action: 'save')}" method="POST">
        <div>
            <label for="name">Nome</label>
            <br>
            <input name="name" value="${params.name}" id="name" type="text">
        </div>
        <g:if test="${flash.errors?.hasFieldErrors('name')}">
            <div>Nome inválido</div>
        </g:if>

        <div>
            <label for="personType">Tipo de pessoa</label>
            <br>
            <select name="personType" id="personType">
                <g:each var="value" in="${PersonType.values()}">
                    <option value="${value}">${value.getLabel()}</option>
                </g:each>
            </select>
        </div>
        
        <div>
            <label for="cpfCnpj">CPF/CNPJ</label>
            <br>
            <input name="cpfCnpj" value="${params.cpfCnpj}" id="cpfCnpj" type="text" maxlength="14">
        </div>
        <g:if test="${flash.errors?.hasFieldErrors('cpfCnpj')}">
            <div>CPF/CNPJ inválido</div>
        </g:if>

        <div>
            <label for="email">Email</label>
            <br>
            <input name="email" value="${params.email}" id="email" type="email">
        </div>
        <g:if test="${flash.errors?.hasFieldErrors('email')}">
            <div>Email inválido</div>
        </g:if>

        <div>
            <label for="phone">Telefone</label>
            <br>
            <input name="phone" value="${params.phone}" id="phone" type="tel" maxlength="10">
        </div>
        <g:if test="${flash.errors?.hasFieldErrors('phone')}">
            <div>Telefone inválido</div>
        </g:if>

        <div>
            <label for="mobilePhone">Celular</label>
            <br>
            <input name="mobilePhone" value="${params.mobilePhone}" id="mobilePhone" type="tel" maxlength="11">
        </div>
        <g:if test="${flash.errors?.hasFieldErrors('mobilePhone')}">
            <div>Celular inválido</div>
        </g:if>

        <div>
            <label for="postalCode">CEP</label>
            <br>
            <input name="postalCode" value="${params.postalCode}" id="postalCode" type="text" maxlength="8">
        </div>
        <g:if test="${flash.errors?.hasFieldErrors('postalCode')}">
            <div>CEP inválido</div>
        </g:if>

        <div>
            <label for="address">Endereço</label>
            <br>
            <input name="address" value="${params.address}" id="address" type="text">
        </div>
        <g:if test="${flash.errors?.hasFieldErrors('address')}">
            <div>Endereço inválido</div>
        </g:if>

        <div>
            <label for="addressNumber">Número</label>
            <br>
            <input name="addressNumber" value="${params.addressNumber}" id="addressNumber" type="text">
        </div>
        <g:if test="${flash.errors?.hasFieldErrors('addressNumber')}">
            <div>Número inválido</div>
        </g:if>

        <div>
            <label for="addressComplement">Complemento</label>
            <br>
            <input name="addressComplement" value="${params.addressComplement}" id="addressComplement" type="text">
        </div>

        <div>
            <label for="district">Bairro</label>
            <br>
            <input name="district" value="${params.district}" id="district" type="text">
        </div>
        <g:if test="${flash.errors?.hasFieldErrors('district')}">
            <div>Bairro inválido</div>
        </g:if>

        <div>
            <label for="city">Cidade</label>
            <br>
            <input name="city" value="${params.city}" id="city" type="text">
        </div>
        <g:if test="${flash.errors?.hasFieldErrors('city')}">
            <div>Cidade inválida</div>
        </g:if>

        <div>
            <label for="state">Estado</label>
            <br>
            <input name="state" value="${params.state}" id="state" type="text">
        </div>
        <g:if test="${flash.errors?.hasFieldErrors('state')}">
            <div>Estado inválido</div>
        </g:if>

        <button type="submit">Salvar</button>
    </form>
</body>
</html>
