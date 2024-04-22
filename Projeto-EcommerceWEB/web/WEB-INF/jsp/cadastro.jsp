<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/cadastro.css" rel="stylesheet" type="text/css"/>
        <link href="css/header-cadastro.css" rel="stylesheet" type="text/css"/>
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <div class="logo-content">
                <img class="logo" src="assets/Logo SoundSpace.png" alt=""/>
                <img class="logo-sing" src="assets/Sound Space Sing.png" alt=""/>
            </div>
        </header>

        <main>
            <div class="contanier">
                <div class="content">
                    <form class="form" method="post" action="cadastrar">
                        <h2>Sign in</h2>

                            <label class="title" for="nome">Nome</label>
                            <input class="form-input" type="text" name="nome" id="nome">

                            <label class="title" for="user">Usuario</label>
                            <input class="form-input" type="text" name="user" id="user">

                            <label class="title" for="password">Senha</label>
                            <input class="form-input" type="password" name="password" id="password">

                            <!-- <label class="title" for="password">Confirmar senha</label>
                            <input class="form-input" type="password" name="confirm-password" id="confirm-password"> -->

                            <label class="title" for="cpf">CPF</label>
                            <input class="form-input" type="text" name="cpf" id="cpf">

                            <label class="title" for="phone">Telefone</label>
                            <input class="form-input" type="text" name="telefone" id="telefone">

                            <button class="form-btn-confirm" type="submit">Cadastrar</button>
                            
                    </form>
                </div>
            </div>
        </main>

        <footer>

        </footer>
    </body>
</html>
