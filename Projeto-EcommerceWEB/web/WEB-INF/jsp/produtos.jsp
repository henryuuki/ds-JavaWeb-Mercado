<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/produtos.css" rel="stylesheet" type="text/css"/>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <title>Produtos</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

        <main>
            <div class="caminho">
                <!-- <p>caminho</p> -->
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

                   
                            <c:forEach items="${produtos}" var="produto">
                                <form action="toUniqueProduct" method="post">
                                    <input type="hidden" id="idProduto" name="idProduto" value="${produto.id_produto}">
                                    <button class="btn-cat-product" type="submit">
                                        <div class="p-cards">
                                            <div class="p-card-item">
                                                <img class="img-card" src="data:image/jpeg;base64,${produto.imagemBase64}" alt="${produto.nome}">
                                            </div>
                                            <div class="p-card-infos">
                                                <span><a href="#">${produto.nome}</a></span>
                                                <span class="p-descricao">Clique para mais informações</span>
                                                <p>$${produto.valor}</p>
                                                <span class="p-descricao">Até 6x de R$${produto.valor / 6}</span>
                                            </div>
                                        </div>
                                    </button>
                                </form>
                            </c:forEach>
                        
                        
                    </section>
                </div>
            </div>
        </main>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
