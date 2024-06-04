<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta name="layout" content="external">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Login</title>
    <asset:stylesheet src="loginpage.css"/>
</head>
<body>
<atlas-screen>
    <atlas-page>
        <atlas-page-header slot="header" page-name="">
        </atlas-page-header>
        <atlas-page-content slot="content" class="js-atlas-content">

            <div id="login">
                <div class="inner">
                    <div class="fheader">Acesse sua conta! ✅</div>

                    <form action="/login/authenticate" method="POST" id="loginForm" class="cssform" autocomplete="off">
                        <p>
                            <label for="username">Email</label>
                            <input type="text" class="text_" name="username" id="username" autocapitalize="none"/>
                        </p>

                        <p>
                            <label for="password">Senha:</label>
                            <input type="password" class="text_" name="password" id="password"/>
                        </p>
                        <div class="button">
                            <atlas-button submit description="Entrar" slot="actions" theme="success"></atlas-button>
                        </div>
                        <div class="bottom-text">
                            <a href="/">Ainda não possui uma conta?</a>
                        </div>
                    </form>
                </div>
            </div>
        </atlas-page-content>
    </atlas-page>
</atlas-screen>
</body>
</html>
