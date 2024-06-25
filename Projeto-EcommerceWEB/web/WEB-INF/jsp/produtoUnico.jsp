<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="css/produto-unico.css" rel="stylesheet" type="text/css" />
            <script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"></script>
            <script type="text/javascript"
                src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
            <title>Produto - Page</title>
        </head>

        <body>
            <jsp:include page="header.jsp"></jsp:include>
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger" role="alert">
                    ${errorMessage}
                </div>
            </c:if>
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
                                <h6 class="h6-notboots">Novo | +10mil vendidos</h6>
                                <span>${produto.nome}</span>
                                <p class="p-descricao">${produto.descricao}</p>
                                <p class="p-preco" id="produto-valor">${produto.valor}</p>
                            </div>
                            <form action="addCarrinho" method="post" class="box-info-baixo">
                                <input type="hidden" value="${produto.id_produto}" id="idProduto" name="idProduto">
                                <button class="button-ss">Comprar</button>
                            </form>
                        </div>

                    </div>
                </div>
            </main>

            <jsp:include page="footer.jsp"></jsp:include>
        </body>
        <script src="js/infos-mask.js" type="text/javascript"></script>

        </html>