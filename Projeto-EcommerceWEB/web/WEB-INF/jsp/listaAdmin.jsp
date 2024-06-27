<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="css/header-admin.css" rel="stylesheet" type="text/css" />
            <link href="css/lista-admin.css" rel="stylesheet" type="text/css" />
            <link href="css/produtos.css" rel="stylesheet" type="text/css" />
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
            <title>Lista Produtos</title>
        </head>

        <body>
            <header>
                <div class="logo-content">
                    <img class="logo" src="assets/Logo SoundSpace.png" alt="" />
                    <img class="logo-sing" src="assets/Sound Space Sing V2.png" alt="" />
                </div>
                <div class="menu">
                    <a class="menu-links" href="./lista-admin">Lista Produtos</a>
                    <a class="menu-links" href="./admin-panel"> Cadastro Produtos</a>
                    <a class="menu-links" href="./cadastro-categoria"> Cadastro Categorias</a>
                </div>
                <form class="form-logout" method="post" action="sair">
                    <div class="icone-content">
                        <button class="icone-btn"><i class="fa-solid fa-right-from-bracket"></i></button>
                    </div>
                </form>
            </header>

            <main>
                <section class="edit">
                    <div class="cat-view">
                        <p class="title-ladm">Lista Categorias</p>
                        <div>
                            <c:forEach items="${categorias}" var="categoria">
                                <span>${categoria.nome}</span>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="prod-view">
                        <div class="prod-view-content">
                            <p class="title-ladm">Lista Produtos</p>
                            <div class="r-cards-content">
                                <c:forEach items="${produtos}" var="produto">
                                    <div class="btn-rec-product">
                                        <input type="hidden" id="idProduto" name="idProduto"
                                            value="${produto.id_produto}">
                                        <div class="r-img">
                                            <img class="img-card" src="data:image/jpeg;base64,${produto.imagemBase64}"
                                                alt="${produto.nome}">
                                        </div>
                                        <div class="r-infos">
                                            <span><a href="#">${produto.nome}</a></span>
                                            <span class="r-descricao">Clique para mais informações</span>
                                            <p>$${produto.valor}</p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </section>
            </main>

            <jsp:include page="footer.jsp"></jsp:include>
        </body>
        <script src="https://kit.fontawesome.com/4f2931e92d.js" crossorigin="anonymous"></script>

        </html>