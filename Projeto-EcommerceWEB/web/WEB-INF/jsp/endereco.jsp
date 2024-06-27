<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="css/cadastro.css" rel="stylesheet" type="text/css" />

            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
            <script src="http://code.jquery.com/jquery-3.7.1.js"></script>
            <script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"></script>
            <script type="text/javascript"
                src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js"></script>
            <title>Endereço</title>
        </head>

        <body>
            <jsp:include page="header.jsp"></jsp:include>

            <main>
                <c:if test="${not empty errorMessage}">
                    <div class="alert alert-danger" role="alert">
                        ${errorMessage}
                    </div>
                </c:if>
                <div class="contanier-inputs-ss">
                    <div class="content-inputs-ss">

                        <form class="form-cadastro" action="cadastrar-endereco" method="post" id="formValidation">
                            <h2>Cadastrar Endereço</h2>

                            <div class="input-caixa">
                                <label class="title" for="nome">Rua</label>
                                <input class="form-input-ss" type="text" name="rua" id="rua">
                            </div>

                            <div class="input-caixa">
                                <label class="title" for="email">Numero</label>
                                <input class="form-input-ss" type="text" name="numero" id="numero">
                            </div>

                            <div class="input-caixa">
                                <label class="title" for="nome">CEP</label>
                                <input class="form-input-ss" type="text" name="cep" id="cep">
                            </div>

                            <div class="input-caixa">
                                <label class="title" for="nome">Complemento (Opicional)</label>
                                <input class="form-input-ss" type="text" name="complemento" id="complemento">
                            </div>

                            <button class="form-btn-confirm" type="submit">Cadastrar</button>
                            <a class="form-link" href="./checkout">Ja possui endereço? <i
                                    class="fa-solid fa-right-long"></i></a>

                        </form>
                    </div>
                </div>
            </main>

            <jsp:include page="footer.jsp"></jsp:include>
        </body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
        <script src="js/errorAlert.js" type="text/javascript"></script>
        <script src="js/validação.js" type="text/javascript"></script>
        </html>