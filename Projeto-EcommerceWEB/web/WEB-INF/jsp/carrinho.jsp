<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link href="css/carrinho.css" rel="stylesheet" type="text/css" />
            <title>Carrinho</title>
        </head>

        <body>
            <jsp:include page="header.jsp"></jsp:include>

            <main>

                <section class="contanier-carrinho-ss">
                    <div class="content-carrinho-ss">
                        <div class="infos-carrinho">

                            <div class="c-info-nomes">
                                <p>Item</p>
                                <p>Descrições</p>
                                <p>Preço</p>
                                <p>Quantidade</p>
                            </div>
                            <c:choose>
                                <c:when test="${empty usuario}">
                                    <p>usuario nao logado</p>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${empty carrinhos}">
                                            <p>Seu carrinho esta vazio</p>
                                        </c:when>
                                        <c:otherwise>
                                            <c:forEach items="${carrinhos}" var="carrinho">
                                                <div class="c-info-img">

                                                    <input type="hidden" id="idUsuario" name="idUsuario"
                                                        value="carrinho.id_carrinho">
                                                    <div class="c-card-item">
                                                        <img class="img-card"
                                                            src="data:image/jpeg;base64,${carrinho.imagemBase64}"
                                                            alt="">
                                                    </div>
                                                    <div class="c-text">
                                                        <p>${carrinho.nomeProduto}</p>
                                                        <p class="c-descricao">${produto.descricao}</p>
                                                    </div>
                                                    <div class="c-preco">
                                                        <p>$${carrinho.valorProduto}</p>
                                                    </div>
                                                    <div class="c-qtd-items">

                                                        <div class="buttons">
                                                            <form action="aumentarQTD" method="post"></form>
                                                            <button id="aumentar">+</button>
                                                            <input type="hidden" name="id_carrinho" id="id_carrinho"
                                                                value="${carrinho.id_carrinho}">
                                                            <input type="hidden" name="quantidade" id="quantidade"
                                                                value="${carrinho.quantidade + 1}">
                                                            </form>
                                                            <p>${carrinho.quantidade}</p>
                                                            <form action="diminuirQTD" method="post">
                                                                <button id="aumentar">-</button>
                                                                <input type="hidden" name="id_carrinho" id="id_carrinho"
                                                                    value="${carrinho.id_carrinho}">
                                                                <input type="hidden" name="quantidade" id="quantidade"
                                                                    value="${carrinho.quantidade - 1}">
                                                            </form>
                                                        </div>

                                                    </div>

                                                </div>
                                            </c:forEach>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>


                            <div class="c-info-total">
                                <p>Total: ${total} </p>
                            </div>

                        </div>

                        <div class="separador"> </div>

                        <div class="info-frete">
                            <div class="frete-text">
                                <span>Calculo Frete</span>
                            </div>
                            <div class="preco-frete">
                                <h3>Resumo Pedido</h3>
                                <div class="calculo">
                                    <p>Produto(s):</p>
                                    <p>Frete:</p>
                                    <p class="preco-total">Total:</p>
                                </div>
                            </div>
                            <div class="box-info-baixo">
                                <button class="button-ss">Finalizar</button>
                            </div>
                        </div>
                    </div>

                </section>

            </main>

            <jsp:include page="footer.jsp"></jsp:include>
        </body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>

        </html>