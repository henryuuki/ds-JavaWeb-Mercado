<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/finalizado.css" rel="stylesheet" type="text/css"/>
        <title>Compra Realizada</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

        <main>  
            <div class="final">
                <img src="assets/checkGreen.png" alt="">
                <h1> Obrigado por sua compra na SoundSpace!</h1>
                <p>Agradecemos imensamente por sua recente compra na SoundSpace! Estamos entusiasmados por você ter escolhido nossa loja para adquirir seus novos aparelhos sonoros.</p>
                <a href="./home"><button>Continuar Comprando</button></a>
            </div>
        </main>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
