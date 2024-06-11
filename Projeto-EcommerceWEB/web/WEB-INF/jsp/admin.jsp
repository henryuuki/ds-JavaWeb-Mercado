<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
            <link href="css/admin.css" rel="stylesheet" type="text/css" />
            <title>Admin Page</title>
        </head>

        <body>
            <header>
                <div>
                    <a href="./cadastro-categoria">Cat</a>
                </div>
            </header>

            <main>
                <div class="contanier">
                    <form action="cadastrar-produto" class="row g-3" method="post" name="frmCadastro"
                        enctype="multipart/form-data">
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">Nome</label>
                            <input class="form-control" type="text" placeholder="Nome Produto" name="nome" id="nome">
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">Descrição</label>
                            <input class="form-control" type="text" placeholder="Descrição" name="descricao"
                                id="descricao">
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Valor</label>
                            <input class="form-control" type="text" placeholder="Valor Unitario" name="valor"
                                id="valor">
                            <div>
                                <div class="mb-4 d-flex justify-content-center">
                                    <img id="selectedImage"
                                        src="https://mdbootstrap.com/img/Photos/Others/placeholder.jpg"
                                        alt="example placeholder" style="width: 300px;" />
                                </div>
                                <div class="d-flex justify-content-center">
                                    <div>
                                        <label class="form-label" for="confirmarSenha">Imagem</label>
                                        <input type="file" id="imagem" name="imagem" required accept="image/*"
                                            class="form-control form-control-lg"
                                            onchange="displaySelectedImage(event, 'selectedImage')" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <select id="categoria" name="categoria" class="form-select form-select-lg">
                            <option value="">Selecione uma categoria</option>

                            <c:forEach items="${categorias}" var="c">
                                <option value="${c.id_categoria}">${c.nome}</option>
                            </c:forEach>

                        </select>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </main>

        </body>
        <script src="js/insertImg.js" type="text/javascript"></script>

        </html>