<%@ page import="com.mini.asaas.utils.FormatUtils" %>
<div class="card">
    <div class="card-header">
        <div class="header-text">
            <atlas-icon name="dollar-sign" size="2x" theme="secondary"></atlas-icon>
            <p>Faturamento</p>
        </div>
    </div>
    <div class="card-content">
        <div class="content-section">
            <div class="section-header">
                <p>PREVISTO</p>
            </div>
            <div class="section-value">
                <div class="display-value alert">
                    <span>R$</span>
                    <p>${FormatUtils.formatBigDecimal(valuesToReceive)}</p>
                </div>
            </div>
        </div>
        <div class="content-section">
            <div class="section-header">
                <p>RECEBIDO</p>
            </div>
            <div class="section-value">
                <div class="display-value success">
                    <span>R$</span>
                    <p>${FormatUtils.formatBigDecimal(valuesReceived)}</p>
                </div>
            </div>
        </div>
    </div>
</div>