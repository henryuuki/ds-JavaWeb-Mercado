<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="css/produtos.css" rel="stylesheet" type="text/css" />
            <link href="css/produto-unico.css" rel="stylesheet" type="text/css" />
            <title>JSP Page</title>
        </head>

        <body>
            <jsp:include page="header.jsp"></jsp:include>

            <main>
                <div class="contanier-pu">
                    <div class="teste">
                        <c:forEach items="${produtos}" var="produto">

                                    <div class="p-cards">
                                        <div class="p-card-item">
                                            <img class="img-card" src="data:image/jpeg;base64,${produto.imagemBase64}" alt="${produto.nome}">
                                        </div>
                                        <div class="p-card-infos">
                                            <span><a href="#">${produto.nome}</a></span>
                                            <span class="p-descricao">${produto.descricao}</span>
                                            <p>$${produto.valor}</p>
                                        </div>
                                    </div>
                        </c:forEach>
                    </div>
                </div>
            </main>

            <jsp:include page="footer.jsp"></jsp:include>
        </body>

        </html>