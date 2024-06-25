<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page pageEncoding="UTF-8" %>
        <%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link href="css/cadastro-categoria.css" rel="stylesheet" type="text/css" />
                <link href="css/header-admin.css" rel="stylesheet" type="text/css" />
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                    crossorigin="anonymous">
                <title>Cadastro Categoria</title>
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
                    <div class="contanier-cadastro">
                        <form action="cadastrar-categoria" class="inputs-cad-prod" method="post" name="formCadastro">
                            <div>
                                <h1>Cadastro de Categoria</h1>
                            </div>
                            <div>
                                <div class="mb-3">
                                    <label for="exampleInputEmail1" class="form-label">Nome</label>
                                    <input class="form-control" type="text" placeholder="Nome Categoria" name="nome"
                                        id="nomeCat">
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Confirmar</button>
                        </form>
                        <form action="cadastrar-setor" class="inputs-cad-prod" method="post" name="formCadastro"
                            enctype="multipart/form-data">
                            <div>
                                <h1>Cadastro de Setor</h1>
                            </div>
                            <div>
                                <div class="mb-3">
                                    <label for="exampleInputEmail1" class="form-label">Nome</label>
                                    <input class="form-control" type="text" placeholder="Nome Setor" name="nome"
                                        id="nomeSet">
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Confirmar</button>
                        </form>
                    </div>
                </main>

                <jsp:include page="footer.jsp"></jsp:include>

            </body>
            <script src="https://kit.fontawesome.com/4f2931e92d.js" crossorigin="anonymous"></script>

            </html>