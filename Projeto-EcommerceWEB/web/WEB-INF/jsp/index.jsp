<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="css/header.css" rel="stylesheet" type="text/css" />
            <link href="css/carousel.css" rel="stylesheet" type="text/css" />
            <link href="css/main.css" rel="stylesheet" type="text/css" />
            <link href="css/cards.css" rel="stylesheet" type="text/css" />
            <link href="css/form.css" rel="stylesheet" type="text/css" />
            <link href="css/alert.css" rel="stylesheet" type="text/css" />
            <link rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
            <script src="https://cdnjs.cloudflare.com/ajax/libs/vanilla-tilt/1.8.1/vanilla-tilt.min.js"
                integrity="sha512-wC/cunGGDjXSl9OHUH0RuqSyW4YNLlsPwhcLxwWW1CR4OeC2E1xpcdZz2DeQkEmums41laI+eGMw95IJ15SS3g=="
                crossorigin="anonymous" referrerpolicy="no-referrer"></script>
            <title>Home - Page</title>
        </head>

        <body>
            <jsp:include page="header.jsp"></jsp:include>

            <main>
                <section class="slider">
                    <div class="slider-content">

                        <input type="radio" name="btn-radio" id="radio1">
                        <input type="radio" name="btn-radio" id="radio2">
                        <input type="radio" name="btn-radio" id="radio3">
                        <input type="radio" name="btn-radio" id="radio4">

                        <div class="slide-box primeiro">
                            <img class="img-desktop" src="assets/BANNER-CAIXA-SOM.jpg" alt="" />
                        </div>

                        <div class="slide-box">
                            <img class="img-desktop" src="assets/Banner loja eletrônicos.png" alt="" />
                        </div>

                        <div class="slide-box">
                            <img class="img-desktop" src="assets/Banner Torres de som.png" alt="" />
                        </div>

                        <div class="slide-box">
                            <img class="img-desktop" src="assets/JBLTopBanner_1200x300.png" alt="" />
                        </div>

                        <div class="nav-auto">
                            <div class="auto-btn1"></div>
                            <div class="auto-btn2"></div>
                            <div class="auto-btn3"></div>
                            <div class="auto-btn4"></div>
                        </div>
                        <div class="nav-manual">
                            <label for="radio1" class="manual-btn"></label>
                            <label for="radio2" class="manual-btn"></label>
                            <label for="radio3" class="manual-btn"></label>
                            <label for="radio4" class="manual-btn"></label>
                        </div>

                    </div>
                </section>

                <hr>

                <h1>Mais Vendidos!</h1>
                <section class="cards">
                    <div class="contanier-3dcards">
                        <div class="card card1">
                            <h2>JBL Flip Es 2</h2>
                            <img class="produto" src="assets/JBL_FLIP_ESSENTIAL_2_BACK_REFLECTIONS_36400_x3.png"
                                alt="" />
                            <button class="button">Comprar</button>
                        </div>
                        <div class="card card2">
                            <h2>JBL PartyBox</h2>
                            <img class="produto" src="assets/JBL_PARTYBOX_ENCORE_ESSENTIAL_HERO_1605x1605px.png"
                                alt="" />
                            <button class="button">Comprar</button>
                        </div>
                        <div class="card card3">
                            <h2>JBL Xtreme 3</h2>
                            <img class="produto" src="assets/JBL_XTREME_3_3_4_RIGHT_BLUE_0072_x1.png" alt="" />
                            <button class="button">Comprar</button>
                        </div>
                        <div class="card card4">
                            <h2>JBL Pulse 5</h2>
                            <img class="produto" src="assets/JBL_PULSE_5_3_4_LEFT_34343_x2.png" alt="" />
                            <a href="./buscar-produtos?busca=5"><button class="button">Comprar</button></a>
                        </div>
                    </div>
                </section>

                <div class="banner">
                    <div>
                        <img class="ad" src="assets/Banner.png" alt="" />
                    </div>
                </div>

                <h3>Recomendações</h3>
                <section class="r-cards-content">
                    <c:forEach items="${produtosRec}" var="produto">
                        <form class="form-rec-prods" action="toUniqueProduct" method="post">
                            <input type="hidden" id="idProduto" name="idProduto" value="${produto.id_produto}">
                            <button class="btn-rec-product" type="submit">
                                <div class="r-img">
                                    <img class="img-card" src="data:image/jpeg;base64,${produto.imagemBase64}"
                                        alt="${produto.nome}">
                                </div>
                                <div class="r-infos">
                                    <span><a href="#">${produto.nome}</a></span>
                                    <span class="r-descricao">Clique para mais informações</span>
                                    <p>$${produto.valor}</p>
                                </div>
                            </button>
                        </form>
                    </c:forEach>
                </section>
                <div class="verMais">
                    <button>Ver Mais!<i class="fa-solid fa-arrow-right"></i></button>
                </div>
            </main>
            <jsp:include page="footer.jsp"></jsp:include>
        </body>
        <script src="https://kit.fontawesome.com/4f2931e92d.js" crossorigin="anonymous"></script>
        <script src="js/carousel.js" type="text/javascript"></script>
        <script src="js/searchBox.js" type="text/javascript"></script>
        <script src="js/card3D.js" type="text/javascript"></script>
        <script src="js/dropdown.js" type="text/javascript"></script>
        <script src="js/popup-form.js" type="text/javascript"></script>
        <script src="js/errorAlert.js" type="text/javascript"></script>

        </html>