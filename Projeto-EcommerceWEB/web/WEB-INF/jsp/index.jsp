<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/carousel.css" rel="stylesheet" type="text/css"/>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="css/cards.css" rel="stylesheet" type="text/css"/>
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/vanilla-tilt/1.8.1/vanilla-tilt.min.js" integrity="sha512-wC/cunGGDjXSl9OHUH0RuqSyW4YNLlsPwhcLxwWW1CR4OeC2E1xpcdZz2DeQkEmums41laI+eGMw95IJ15SS3g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <title>Home - Page</title>
    </head>

    <body>
        <header>
            <nav>
                <div class="logo-content">
                    <img class="logo" src="assets/Logo SoundSpace.png" alt=""/>
                    <img class="logo-sing" src="assets/Sound Space Sing.png" alt=""/>
                    <!-- <a href="./cadastrar">cadastro</a>
                    <a href="./lista-produtos">produtos</a>
                    <a href="./login">login</a>
                    <a href="./produto-unico">produto unico</a> -->
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
                    <a class="menu-links" href="">Home</a>
                    <a class="menu-links" href="">Contato</a>               
                    <a class="menu-links" href="">Sobre</a>               
                </div>

                <div class="dropdown">
                    <div class="icons-content">
                        <button class="icon-btn"><i class="bi bi-cart"></i></button>
                        <button id="perfilDropdown" class="icon-btn dropbtn"><i class="bi bi-person-circle"></i></button>
                        <div class="dropdown-content">
                            <a href="">1</a>
                            <a href="">2</a>
                            <a href="">3</a>
                        </div>
                    </div>
                </div>
            </nav>
            <div class="categorias">

            </div>
        </header>

        <main>
            <section class="slider">
                <div class="slider-content">

                    <input type="radio" name="btn-radio" id="radio1">
                    <input type="radio" name="btn-radio" id="radio2">
                    <input type="radio" name="btn-radio" id="radio3">
                    <input type="radio" name="btn-radio" id="radio4">

                    <div class="slide-box primeiro"> 
                        <img class="img-desktop" src="assets/BANNER-CAIXA-SOM.jpg" alt=""/>
                    </div>

                    <div class="slide-box">
                        <img class="img-desktop" src="assets/11409102.jpg" alt=""/>
                    </div>

                    <div class="slide-box">
                        <img class="img-desktop" src="assets/10028691.jpg" alt=""/>
                    </div>

                    <div class="slide-box">
                        <img class="img-desktop" src="assets/JBLTopBanner_1200x300.png" alt=""/>
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

                <div class="card card1">
                    <h2>JBL Flip Es 2</h2>
                    <img class="produto" src="assets/JBL_FLIP_ESSENTIAL_2_BACK_REFLECTIONS_36400_x3.png" alt=""/>
                    <button class="button">Comprar</button>
                </div>
                <div class="card card2">
                    <h2>JBL PartyBox</h2>
                    <img class="produto" src="assets/JBL_PARTYBOX_ENCORE_ESSENTIAL_HERO_1605x1605px.png" alt=""/>
                    <button class="button">Comprar</button>
                </div>
                <div class="card card3">
                    <h2>JBL Xtreme 3</h2>
                    <img class="produto" src="assets/JBL_XTREME_3_3_4_RIGHT_BLUE_0072_x1.png" alt=""/>
                    <button class="button">Comprar</button>
                </div>
                <div class="card card4">
                    <h2>JBL Pulse 5</h2>
                    <img class="produto" src="assets/JBL_PULSE_5_3_4_LEFT_34343_x2.png" alt=""/>
                    <button class="button">Comprar</button>
                </div>

            </section>

            <div class="banner">
                <div">
                    <img class="ad" src="assets/Banner.png" alt=""/>
                </div>
            </div>

            <h3>Recomendações</h3>
            <section class="r-cards1">
                <div class="r-card">
                    <h2>Teste</h2>
                </div>
                <div class="r-card">
                    <h2>Teste</h2>
                </div>
                <div class="r-card">
                    <h2>Teste</h2>
                </div>
                <div class="r-card">
                    <h2>Teste</h2>
                </div>
            </section>

            <section class="r-cards2">
                <div class="r-card">
                    <h2>Teste</h2>
                </div>
                <div class="r-card">
                    <h2>Teste</h2>
                </div>
                <div class="r-card">
                    <h2>Teste</h2>
                </div>
                <div class="r-card">
                    <h2>Teste</h2>
                </div>
            </section>
            <div class="verMais"><button>Ver Mais!  <i class="fa-solid fa-arrow-right"></i></button></div>
        </main>

        <footer>
    
        </footer>
    </body>
    <script src="https://kit.fontawesome.com/4f2931e92d.js" crossorigin="anonymous"></script>
    <script src="js/carousel.js" type="text/javascript"></script>
    <script src="js/searchBox.js" type="text/javascript"></script>
    <script src="js/card3D.js" type="text/javascript"></script>
    <script src="js/dropdown.js" type="text/javascript"></script>
</html>
