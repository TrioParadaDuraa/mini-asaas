<div class="card">
    <div class="card-header">
        <div class="header-text">
            <atlas-icon name="money" size="2x" theme="secondary"></atlas-icon>
            <p>Cobranças</p>
        </div>
    </div>
    <div class="card-content">
        <div class="content-section">
            <div class="section-header">
                <p>PREVISTAS</p>
            </div>
            <div class="section-value">
                <div class="display-value alert">
                    <p>${paymentList.size()}</p>
                </div>
            </div>
        </div>
        <div class="content-section">
            <div class="section-header">
                <p>VENCIDAS</p>
            </div>
            <div class="section-value">
                <div class="display-value danger">
                    <p>${overduePayments.size()}</p>
                </div>
            </div>
        </div>
        <div class="content-section">
            <div class="section-header">
                <p>RECEBIDAS</p>
            </div>
            <div class="section-value">
                <div class="display-value success">
                    <p>${receivedPayments.size()}</p>
                </div>
            </div>
        </div>
    </div>
</div>