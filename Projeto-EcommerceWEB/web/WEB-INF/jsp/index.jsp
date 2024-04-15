<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/carousel.css" rel="stylesheet" type="text/css"/>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="css/flipcard.css" rel="stylesheet" type="text/css"/>
        <title>Home - Page</title>
    </head>

    <body>
        <header>
            <nav>
                <div class="logo-content">
                    <img class="logo" src="assets/Logo SoundSpace.png" alt=""/>
                    <img class="logo-sing" src="assets/Sound Space Sing.png" alt=""/>
                    <a href="WEB-INF/jsp/Carrinho.jsp">a</a>
                </div>

                <div class="h-content">
                    <input class="input-style"  type="text" placeholder=" Buscar" />
                    <button class="btn-search" type="submit">
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </button>
                </div>

                <div class="p-content">
                    <img class="perfil" src="assets/user-black64px.png" alt=""/>
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
            <div class="container">
                <div class="flip">
                    <div class="frente">
                        <!-- <img src="assets/JBL_FLIP_ESSENTIAL_2_BACK_REFLECTIONS_36400_x3.png" alt=""/> -->
                    </div>
                    <div class="tras">
                        <p>Leite</p>
                    </div>
                </div>
            </div>
        </main>
    </body>
    <script src="js/carousel.js" type="text/javascript"></script>
    <script src="https://kit.fontawesome.com/4f2931e92d.js" crossorigin="anonymous"></script>
</html>
