<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/produtos.css" rel="stylesheet" type="text/css"/>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

        <main>
            <div class="caminho">
                <p>aaaaaaaaaaaaaaaaaaaaaaa</p>
            </div>
            <div class="content-products">
                <div class="categoria-lista">
                    <div class="cat-lis-links">
                        <h1>Categorias</h1>
                        <a href="">Caixas de Som</a>
                        <a href="">SoundBars</a>
                        <a href="">Para TVs</a>
                        <a href="">Para Computadores</a>
                    </div>
                </div>
                <div class="cards-categorias">
                    <section class="products-cards">
                        <div class="p-cards">
                            <div class="p-card-item">
                                
                            </div>
                            <div class="p-card-infos">
                                <span>Produto</span>
                                <p>Preço</p>
                            </div>
                        </div>
                        <div class="p-cards"></div>
                        <div class="p-cards"></div>
                        <div class="p-cards"></div>
                        <div class="p-cards"></div>
                        <div class="p-cards"></div>
                        <div class="p-cards"></div>
                        <div class="p-cards"></div>
                        <div class="p-cards"></div>
                    </section>
                </div>
            </div>
        </main>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
