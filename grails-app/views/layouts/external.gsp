<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <title>
            <g:layoutTitle default="Mini-Asaas" />
        </title>
        <link rel="stylesheet" href="https://atlas.asaas.com/v17.6.2/atlas.min.css" crossorigin="anonymous">
        <script defer src="https://atlas.asaas.com/v17.6.2/atlas.min.js" crossorigin="anonymous"></script>
        <asset:stylesheet src="application.css"/>
        <asset:link rel="icon" href="asaas-icon.png" type="image/x-icon"/>
        <g:layoutHead/>
    </head>
    <body>
        <atlas-screen>
            <div class="navbar-layout">
                <a href="/">
                    <atlas-icon size="6x" white="" name="chevron-left"></atlas-icon>
                </a>
                <asset:image src="/homepage/asaas-logo.png" class="asaas-logo"/>
            </div>
            <atlas-page>
                <atlas-page-header slot="header" page-name="${pageProperty(name: 'body.title')}">
                </atlas-page-header>
                <atlas-page-content slot="content" class="js-atlas-content">
                    <g:layoutBody/>
                </atlas-page-content>
            </atlas-page>
        </atlas-screen>
    </body>
</html>