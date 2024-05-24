<!DOCTYPE html>
<html lang="pt-br">
  <head>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <title>
        <g:layoutTitle default="Grails" />
      </title>
      <link rel="stylesheet" href="https://atlas.asaas.com/v17.6.2/atlas.min.css" crossorigin="anonymous">
      <script defer src="https://atlas.asaas.com/v17.6.2/atlas.min.js" crossorigin="anonymous"></script>
    <g:layoutHead/>
  </head>
  <body>
      <atlas-screen>
          <atlas-navbar slot="navbar"></atlas-navbar>
          <atlas-page>
              <atlas-page-header slot="header" page-name="${pageProperty(name: 'body.page.title')}">
                  <atlas-breadcrumb slot="breadcrumb">
                      <atlas-breadcrumb-item text="${pageProperty(name: 'body.page.title')}"
                                              icon="home"></atlas-breadcrumb-item>
                  </atlas-breadcrumb>
              </atlas-page-header>
              <atlas-page-content slot="content" class="js-atlas-content">
                  <g:layoutBody/>
              </atlas-page-content>
          </atlas-page>
      </atlas-screen>
  </body>
</html>