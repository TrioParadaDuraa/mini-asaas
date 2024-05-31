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
        <atlas-sidebar slot="sidebar">
            <atlas-sidebar-menu slot="body">
                <atlas-sidebar-menu-item
                        icon="cog"
                        value=""
                        text="Minha conta"
                        href="">

                        <atlas-sidebar-menu-item
                                icon="user"
                                value=""
                                text="Meus dados"
                                href=""
                        ></atlas-sidebar-menu-item>

                        <atlas-sidebar-menu-item
                            icon="pencil"
                            value=""
                            text="Atualizar dados"
                            href="${createLink(controller: 'customer', action: 'show', id: 1)}"
                        ></atlas-sidebar-menu-item>

                </atlas-sidebar-menu-item>
            </atlas-sidebar-menu>
        </atlas-sidebar>
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