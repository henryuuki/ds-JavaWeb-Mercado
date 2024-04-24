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

                            <div class="input-box">
                                <label class="title" for="nome">Nome</label>
                                <input class="form-input" type="text" name="nome" id="nome">
                                <i class="bi bi-lock-fill"></i>
                            </div>

                            <div>
                                <label class="title" for="email">Email</label>
                                <input class="form-input" type="email" name="email" id="email">
                            </div>

                            <div>
                                <label class="title" for="password">Senha</label>
                                <input class="form-input" type="password" name="password" id="password">
                            </div>

                            <!-- <label class="title" for="password">Confirmar senha</label>
                            <input class="form-input" type="password" name="confirm-password" id="confirm-password"> -->
                            <div>
                                <label class="title" for="cpf">CPF</label>
                                <input class="form-input" type="text" name="cpf" id="cpf">
                            </div>

                            <div>
                                <label class="title" for="phone">Telefone</label>
                                <input class="form-input" type="tel" name="telefone" id="telefone">
                            </div>

                            <button class="form-btn-confirm" type="submit">Cadastrar</button>
                            <a class="form-link" href="./index.htm">Ja possui conta? Login</a>
                            
                    </form>
                </div>
            </div>
        </main>

        <footer>

        </footer>
    </body>
</html>
