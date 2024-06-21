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

            <!-- <h2>Carrinho de compra</h2> -->
            <section class="contanier-carrinho-ss">
                <div class="content-carrinho-ss">
                    <div class="infos-carrinho">

                        <div class="c-info-nomes">
                            <p>Item</p>
                            <p>Descrições</p>
                            <p>Preço</p>
                            <p>Quantidade</p>
                        </div>
                        <div class="c-info-img">

                            <div class="c-card-item">

                            </div>
                            <div class="c-text">
                                <p>${produto.nome}</p>
                                <p class="c-descricao">${produto.descricao}</p>
                            </div>
                            <div class="c-preco">
                                <p class="p-preco">$${produto.valor}</p>
                            </div>
                            <div class="c-qtd-items">

                            </div>

                        </div>
                        <div class="c-info-total">
                            <p>Total: </p>
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