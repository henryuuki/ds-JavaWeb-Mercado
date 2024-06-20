<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="css/cadastro.css" rel="stylesheet" type="text/css" />
            <link href="css/header-cadastro.css" rel="stylesheet" type="text/css" />
            <link href="css/footer.css" rel="stylesheet" type="text/css" />
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
            <script src="https://cdnjs.cloudflare.com/ajax/libs/vanilla-tilt/1.8.1/vanilla-tilt.min.js"
                integrity="sha512-wC/cunGGDjXSl9OHUH0RuqSyW4YNLlsPwhcLxwWW1CR4OeC2E1xpcdZz2DeQkEmums41laI+eGMw95IJ15SS3g=="
                crossorigin="anonymous" referrerpolicy="no-referrer"></script>
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
            <script src="http://code.jquery.com/jquery-3.7.1.js"></script>
            <script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"></script>
            <script type="text/javascript"
                src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js"></script>
            <title>Cadastrar</title>
        </head>

        <body>
            <header>
                <div class="logo-content">
                    <a href="./home"><img class="logo" src="assets/Logo SoundSpace.png" alt="" /></a>
                    <img class="logo-sing" src="assets/Sound Space Sing.png" alt="" />
                </div>

                <div class="input-contanier">
                    <div class="input-content">
                        <div class="btn-search">
                            <i class="bi bi-search"></i>
                        </div>
                        <div class="input-style">
                            <input type="text" name="" placeholder="Procure o que deseja">
                        </div>
                        <div class="btn-close">
                            <i class="bi bi-x-lg"></i>
                        </div>
                    </div>
                </div>

                <div class="menu">
                    <a class="menu-links" href="./home">Home</a>
                    <a class="menu-links" href="">Contato</a>
                    <a class="menu-links" href="">Sobre</a>
                </div>
            </header>

            <main>

                <c:if test="${not empty errorMessage}">
                    <div class="alert alert-danger" role="alert">
                        ${errorMessage}
                    </div>
                </c:if>

                <c:if test="${not empty successMessage}">
                    <div class="alert alert-success" role="alert">
                        ${successMessage}
                    </div>
                </c:if>

                <div class="contanier-inputs-ss">
                    <div class="content-inputs-ss">

                        <form class="form-cadastro" action="cadastrar" method="post" id="formValidation">
                            <h2>Sign in</h2>

                            <div class="input-caixa">
                                <label class="title" for="nome">Nome</label>
                                <input class="form-input-ss" type="text" name="nome" id="nome">
                                <i class="bi bi-person-fill"></i>
                            </div>

                            <div class="input-caixa">
                                <label class="title" for="email">Email</label>
                                <input class="form-input-ss" type="email" name="email" id="email">
                                <i class="bi bi-envelope-fill"></i>
                            </div>

                            <div class="input-caixa">
                                <label class="title" for="password">Senha</label>
                                <input class="form-input-ss" type="password" name="password" id="password">
                                <i class="bi bi-check2"></i>
                            </div>

                            <div class="input-caixa">
                                <label class="title" for="password">Confirmar senha</label>
                                <input class="form-input-ss" type="password" name="confirm-password"
                                    id="confirm-password">
                                <i class="bi bi-check2-all"></i>
                            </div>

                            <div class="input-caixa">
                                <label class="title" for="cpf">CPF</label>
                                <input class="form-input-ss" type="text" name="cpf" id="cpf">
                                <i class="bi bi-file-earmark-check-fill"></i>
                            </div>

                            <div class="input-caixa">
                                <label class="title" for="phone">Telefone</label>
                                <input class="form-input-ss" type="tel" name="telefone" id="telefone">
                                <i class="bi bi-telephone-fill"></i>
                            </div>

                            <button class="form-btn-confirm" type="submit">Cadastrar</button>
                            <a class="form-link" href="./home">Ja possui conta? Login</a>

                        </form>
                    </div>
                </div>
            </main>

            <jsp:include page="footer.jsp"></jsp:include>

        </body>
        <script src="js/searchBox.js" type="text/javascript"></script>
        <script src="js/validação.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

        </html>