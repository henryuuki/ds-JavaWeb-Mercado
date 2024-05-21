<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="css/admin.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="contanier">
            <form class="formulario" method="post" action="cadastrar-produto">
                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label">Nome</label>
                  <input class="form-control" type="text" placeholder="Nome Produto" name="nome" id="nome">
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Descrição</label>
                  <input class="form-control" type="text" placeholder="Descrição" name="descricao" id="descricao">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Valor</label>
                    <input class="form-control" type="text" placeholder="Valor Unitario" name="valor" id="valor">
                <div class="mb-3">
                    <label for="formFile" class="form-label">Imagem</label>
                    <input class="form-control" type="file" name="imagem" id="imagem">
                </div>
                <select class="form-select" aria-label="Default select example">
                    <option selected>Open this select menu</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
                <button type="submit" class="btn btn-primary">Submit</button>
              </form>
        </div>

    </body>
</html>
