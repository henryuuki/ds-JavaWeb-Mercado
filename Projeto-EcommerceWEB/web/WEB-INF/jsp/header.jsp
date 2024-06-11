<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="css/header.css" rel="stylesheet" type="text/css" />
            <link href="css/cards.css" rel="stylesheet" type="text/css" />
            <link href="css/form.css" rel="stylesheet" type="text/css" />
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
            <script src="https://cdnjs.cloudflare.com/ajax/libs/vanilla-tilt/1.8.1/vanilla-tilt.min.js"
                integrity="sha512-wC/cunGGDjXSl9OHUH0RuqSyW4YNLlsPwhcLxwWW1CR4OeC2E1xpcdZz2DeQkEmums41laI+eGMw95IJ15SS3g=="
                crossorigin="anonymous" referrerpolicy="no-referrer"></script>
            <title>JSP Page</title>
        </head>

        <body>
            <header>
                <nav>
                    <div class="logo-content">
                        <img class="logo" src="assets/Logo SoundSpace.png" alt="" />
                        <img class="logo-sing" src="assets/Sound Space Sing.png" alt="" />
                        <!-- <a href="./cadastrar">cadastro</a>
                    <a href="./lista-produtos">produtos</a>
                    <a href="./produto-unico">produto unico</a>
                    <a href="./admin-panel">admin</a> -->
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
                        <a class="menu-links" href="#under">Contato</a>
                        <a class="menu-links" href="#under">Sobre</a>
                    </div>

                    <div class="icons-content">
                        <button class="icon-btn"><i class="fa-solid fa-cart-shopping"></i></button>
                        <button class="icon-btn" type="submit" id="perfil-btn"><i
                                class="bi bi-person-circle"></i></button>
                    </div>

                    <div class="popup">
                        <div class="close-form"><i class="bi bi-x"></i></div>
                        <form class="form" method="post" action="logar">
                            <h2>Log in</h2>

                            <i class="bi bi-person-fill"></i>
                            <label class="title" for="email">Email</label>
                            <input class="form-input" type="email" name="email" id="email" placeholder="Enter email">

                            <i class="bi bi-lock-fill"></i>
                            <label class="title" for="password">Senha</label>
                            <input class="form-input" type="password" name="password" id="password"
                                placeholder="Enter password">

                            <input class="form-checkbox" type="checkbox" id="remember-me">
                            <label class="title" for="remember-me">Lembrar de mim</label>

                            <button class="form-btn-confirm" type="submit">Logar</button>

                            <a class="form-link" href="./cadastrar">Não tem conta? Crie uma</a>
                        </form>
                    </div>
                    <!-- <div class="dropdown">
                    <div class="icons-content">
                        <button class="icon-btn"><i class="bi bi-cart"></i></button>
                        <button onclick="myFunction()" class="icon-btn dropbtn" type="submit"><i class="bi bi-person-circle"></i></button>
                        <div id="perfilDropdown" class="dropdown-content">
                            <a href="">1</a>
                            <a href="">2</a>
                            <a href="">3</a>
                        </div>
                    </div>
                </div> -->
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
        <script src="https://kit.fontawesome.com/4f2931e92d.js" crossorigin="anonymous"></script>
        <script src="js/searchBox.js" type="text/javascript"></script>
        <script src="js/popup-form.js" type="text/javascript"></script>

        </html>