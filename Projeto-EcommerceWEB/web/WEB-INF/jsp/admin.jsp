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
                <div class="logo-content">
                    <img class="logo" src="assets/Logo SoundSpace.png" alt="" />
                    <img class="logo-sing" src="assets/Sound Space Sing V2.png" alt="" />
                    <!-- <a href="./cadastrar">cadastro</a>
                    <a href="./lista-produtos">produtos</a>
                    <a href="./produto-unico">produto unico</a> -->
                </div>
                <div class="menu">
                    <a class="menu-links" href="#under">Lista Produtos</a>
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
                <div class="contanier-admin">
                    <form action="cadastrar-produto" class="row g-3" method="post" name="frmCadastro"
                        enctype="multipart/form-data">

                        <div>
                            <h1>Cadastro de Produtos</h1>
                        </div>

                        <div class="grid-prod-form">
                            <div class="inputs-cad-prod">
                                <div class="mb-3">
                                    <label for="exampleInputEmail1" class="form-label">Nome</label>
                                    <input class="form-control" type="text" placeholder="Nome Produto" name="nome"
                                        id="nome">
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
                                </div>
                                <select id="categoria" name="categoria" class="form-select form-select-lg">
                                    <option value="">Selecione uma categoria</option>

                                    <c:forEach items="${categorias}" var="c">
                                        <option value="${c.id_categoria}">${c.nome}</option>
                                    </c:forEach>

                                </select>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>

                            <div class="img-cad-prod">
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
                    </form>
                </div>
            </main>

        </body>
        <script src="https://kit.fontawesome.com/4f2931e92d.js" crossorigin="anonymous"></script>
        <script src="js/insertImg.js" type="text/javascript"></script>

        </html>