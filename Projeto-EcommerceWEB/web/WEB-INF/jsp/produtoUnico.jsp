<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="css/produto-unico.css" rel="stylesheet" type="text/css" />
            <title>Produto Page</title>
        </head>

        <body>
            <jsp:include page="header.jsp"></jsp:include>

            <main>
                <div class="contanier-pu">
                    <div class="box">

                        <div class="p-cards">
                            <div class="p-card-item">
                                <img class="img-card" src="data:image/jpeg;base64,${produto.imagemBase64}"
                                    alt="${produto.nome}">
                            </div>
                        </div>
                        <div class="p-card-infos">
                            <div>
                                <h6>Novo | +10mil vendidos</h6>
                                <span>${produto.nome}</span>
                                <p class="p-descricao">${produto.descricao}</p>
                                <p class="p-preco">$${produto.valor}</p>
                            </div>
                            <div class="box-info-baixo">
                                <button class="button">Comprar</button>
                            </div>
                        </div>

                    </div>
                </div>
            </main>

            <jsp:include page="footer.jsp"></jsp:include>
        </body>

        </html>