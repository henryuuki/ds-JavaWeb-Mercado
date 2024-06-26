<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="css/header.css" rel="stylesheet" type="text/css" />
            <link href="css/cards.css" rel="stylesheet" type="text/css" />
            <link href="css/form.css" rel="stylesheet" type="text/css" />
            <link href="css/alert.css" rel="stylesheet" type="text/css" />
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
            <script src="https://cdnjs.cloudflare.com/ajax/libs/vanilla-tilt/1.8.1/vanilla-tilt.min.js"
                integrity="sha512-wC/cunGGDjXSl9OHUH0RuqSyW4YNLlsPwhcLxwWW1CR4OeC2E1xpcdZz2DeQkEmums41laI+eGMw95IJ15SS3g=="
                crossorigin="anonymous" referrerpolicy="no-referrer"></script>
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
            <script src="https://kit.fontawesome.com/4f2931e92d.js" crossorigin="anonymous"></script>
            <title>Header</title>
        </head>

        <body>
            <header>
                <c:if test="${not empty sessionScope.errorLoginMessage}">
                    <div class="alert alert-danger alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <strong>Erro: </strong> ${sessionScope.errorLoginMessage}
                        <c:remove var="errorLoginMessage" scope="session" />
                    </div>
                </c:if>
                <nav>
                    <div class="logo-content">
                        <a href="./home"><img class="logo" src="assets/Logo SoundSpace.png" alt="" /></a>
                        <img class="logo-sing" src="assets/Sound Space Sing.png" alt="" />
                        <!-- <a href="./admin-panel">admin</a> -->
                    </div>

                    <div class="input-contanier">
                        <div class="input-content">

                            <div class="btn-search">
                                <i class="bi bi-search"></i>
                            </div>

                            <div class="input-style">
                                <form action="buscar-produtos" method="get">
                                    <input name="busca" placeholder="Procure o que deseja" aria-label="Search">
                                </form>
                            </div>

                            <div class="btn-fechar">
                                <i class="bi bi-x-lg"></i>
                            </div>

                        </div>
                    </div>

                    <div class="menu">
                        <a class="menu-links" href="./home">Home</a>
                        <a class="menu-links" href="#under">Contato</a>
                        <a class="menu-links" href="#under">Sobre</a>
                    </div>

                    <c:choose>
                        <c:when test="${empty usuario}">

                            <div class="icones-content">
                                <button class="icone-btn" type="submit" id="perfil-btn2"><i
                                        class="fa-solid fa-cart-shopping"></i></button>
                                <button class="icone-btn" type="submit" id="perfil-btn1"><i
                                        class="bi bi-person-circle"></i></button>
                            </div>

                            <div class="popup">

                                <div class="close-form"><i class="bi bi-x"></i></div>
                                <form class="form" method="post" action="logar">
                                    <h2>Log in</h2>

                                    <i class="bi bi-person-fill"></i>
                                    <label class="title" for="email">Email</label>
                                    <input class="form-input" type="email" name="email" id="email"
                                        placeholder="Enter email">

                                    <i class="bi bi-lock-fill"></i>
                                    <label class="title" for="password">Senha</label>
                                    <input class="form-input" type="password" name="password" id="password"
                                        placeholder="Enter password">

                                    <!-- <input class="form-checkbox" type="checkbox" id="remember-me">
                                    <label class="title" for="remember-me">Lembrar de mim</label> -->

                                    <button class="form-btn-confirm" type="submit">Logar</button>

                                    <a class="form-link" href="./cadastrar">Não tem conta? Crie uma</a>
                                </form>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="icones-content">
                                <a href="./carrinho"><button class="icone-btn"><i
                                            class="fa-solid fa-cart-shopping"></i></button></a>
                                <button class="icone-btn" type="submit" id="perfil-btn1"><i
                                        class="bi bi-person-circle"></i></button>
                                <form class="form-logout" method="post" action="sair">
                                    <button class="icone-btn"><i class="fa-solid fa-right-from-bracket"></i></button>
                                </form>
                            </div>

                            <div class="popup">

                                <div class="close-form"><i class="bi bi-x"></i></div>
                                <form class="form" method="post" action="logar">
                                    <h2>Log in</h2>
                                    <a class="form-link" href="./cadastrar">Não tem conta? Crie uma</a>
                                </form>
                            </div>
                        </c:otherwise>
                    </c:choose>


                    </div>
                </nav>
                <div class="categorias">
                    <div class="space"></div>
                    <ul class="nav-cat">
                        <a href="#">
                            <p>Categorias</p>
                        </a>
                        <p> | </p>
                        <c:forEach items="${categorias}" var="categoria">
                            <li><a href="./lista-produtos?cat=${categoria.id_categoria}">${categoria.nome}</a></li>
                        </c:forEach>
                    </ul>
                </div>

            </header>
        </body>
        <script src="js/searchBox.js" type="text/javascript"></script>
        <script src="js/popup-form.js" type="text/javascript"></script>
        <script src="js/errorAlert.js" type="text/javascript"></script>
        </html>