<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/checkout.css" rel="stylesheet" type="text/css"/>
        <title>Checkout</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

        <main>
            <div class="contanier-checkout">
                <section class="content-checkout">
                    <div class="pagamento">
                        <h1>Endereço</h1>
                    </div>
                    <div class="endereco">
                        <h1>Pagamento</h1>
                    </div>
                </section>
                <div class="btn-check-finalizar">
                    <h1>FINALIZA</h1>
                </div>
            </div>
        </main>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
