<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="css/checkout.css" rel="stylesheet" type="text/css" />
            <link href="css/radios.css" rel="stylesheet" type="text/css" />
            <link href="css/footer-checkout.css" rel="stylesheet" type="text/css" />
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
            <title>Checkout</title>
        </head>

        <body>
            <jsp:include page="header.jsp"></jsp:include>

            <main>
                <div class="contanier-checkout">
                    <section class="content-checkout">
                        <c:choose>
                            <c:when test="${empty usuario}">
                                <div class="endereco">
                                    <div class="infos-usuario">
                                        <div class="aviso-vazio">
                                            <span>Usuario não logado</span>
                                        </div>
                                        <h2>1. Dados Pessoais</h2>
                                        <p>Nome: ${usuarios.nome}</p>
                                        <p>Email: ${usuarios.email}</p>
                                        <p>Telefone: ${usuarios.telefone}</p>
                                    </div>
                                    <div class="infos-endereco">
                                        <h2>2. Endereço</h2>
                                        <p>Endereço: ${endereco.rua}</p>
                                        <p>Numero: </p>
                                        <p>CEP: ${endereco.cep}</p>
                                        <p>Complemento: ${endereco.complemento}</p>
                                        <div class="content-btn-end">

                                        </div>
                                    </div>
                                </div>



                                <div class="pagamento">
                                    <h2>3. Pagamento</h2>
                                    <div class="content-drop">
                                        <div class="dropdown-center">
                                            <button class="btn btn-secondary dropdown-toggle" type="button"
                                                data-bs-toggle="dropdown" aria-expanded="false">
                                                Cartão Credito
                                            </button>
                                            <div class="dropdown-menu">
                                                <form class="px-4 py-3">
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Nome
                                                            Completo</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Numero
                                                            Cartão</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">CVC</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default" max="3"
                                                            min="3">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Data
                                                            de
                                                            Validade</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <button type="submit" class="btn btn-primary">Validar</button>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="dropdown-center">
                                            <button class="btn btn-secondary dropdown-toggle" type="button"
                                                data-bs-toggle="dropdown" aria-expanded="false">
                                                Cartão Debito
                                            </button>
                                            <div class="dropdown-menu">
                                                <form class="px-4 py-3">
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Nome
                                                            Completo</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Numero
                                                            Cartão</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">CVC</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default" max="3"
                                                            min="3">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Data
                                                            de
                                                            Validade</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <button type="submit" class="btn btn-primary">Validar</button>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="dropdown-center">
                                            <button class="btn btn-secondary dropdown-toggle" type="button"
                                                data-bs-toggle="dropdown" aria-expanded="false">
                                                Pix
                                            </button>
                                            <div class="dropdown-menu">
                                                <form class="px-4 py-3">
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Nome
                                                            Completo</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Numero
                                                            Cartão</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">CVC</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default" max="3"
                                                            min="3">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Data
                                                            de
                                                            Validade</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <button type="submit" class="btn btn-primary">Validar</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="btn-check-finalizar">
                                        <button type="submit" class="btn btn-primary">Finalizar</button>
                                    </div>
                                </div>
                            </c:when>


                            <c:otherwise>
                                <div class="endereco">
                                    <div class="infos-usuario">
                                        <h2>1. Dados Pessoais</h2>
                                        <p>Nome: ${usuarios.nome}</p>
                                        <p>Email: ${usuarios.email}</p>
                                        <p>Telefone: ${usuarios.telefone}</p>
                                    </div>
                                    <div class="infos-endereco">
                                        <h2>2. Endereço</h2>
                                        <p>Endereço: ${endereco.rua}</p>
                                        <p>Numero: ${endereco.numero}</p>
                                        <p>CEP: ${endereco.cep}</p>
                                        <p>Complemento: ${endereco.complemento}</p>
                                        <div class="content-btn-end">
                                            <c:choose>
                                                <c:when test="${empty enderecos}">
                                                    <a href="./endereco"><button type="button"
                                                            class="btn btn-secondary"><i class="fa-solid fa-plus"></i>
                                                            Adicionar endereço</button></a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="./endereco"><button type="button"
                                                            class="btn btn-secondary"><i
                                                                class="fa-solid fa-pen-to-square"></i> Atualizar
                                                            endereço</button></a>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                </div>



                                <div class="pagamento">
                                    <h2>3. Pagamento</h2>
                                    <!-- <div class="content-drop">
                                        <div class="dropdown-center">
                                            <button class="btn btn-secondary dropdown-toggle" type="button"
                                                data-bs-toggle="dropdown" aria-expanded="false">
                                                Cartão Credito
                                            </button>
                                            <div class="dropdown-menu">
                                                <form class="px-4 py-3">
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Nome
                                                            Completo</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Numero
                                                            Cartão</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">CVC</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default" max="3"
                                                            min="3">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Data
                                                            de
                                                            Validade</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <button type="submit" class="btn btn-primary">Validar</button>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="dropdown-center">
                                            <button class="btn btn-secondary dropdown-toggle" type="button"
                                                data-bs-toggle="dropdown" aria-expanded="false">
                                                Cartão Debito
                                            </button>
                                            <div class="dropdown-menu">
                                                <form class="px-4 py-3">
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Nome
                                                            Completo</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Numero
                                                            Cartão</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">CVC</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default" max="3"
                                                            min="3">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Data
                                                            de
                                                            Validade</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <button type="submit" class="btn btn-primary">Validar</button>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="dropdown-center">
                                            <button class="btn btn-secondary dropdown-toggle" type="button"
                                                data-bs-toggle="dropdown" aria-expanded="false">
                                                Pix
                                            </button>
                                            <div class="dropdown-menu">
                                                <form class="px-4 py-3">
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Nome
                                                            Completo</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Numero
                                                            Cartão</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">CVC</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default" max="3"
                                                            min="3">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                            id="inputGroup-sizing-default">Data
                                                            de
                                                            Validade</span>
                                                        <input type="text" class="form-control"
                                                            aria-label="Sizing example input"
                                                            aria-describedby="inputGroup-sizing-default">
                                                    </div>
                                                    <button type="submit" class="btn btn-primary">Validar</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div> -->
                                    <!-- <div class="btn-check-finalizar">
                                        <a href="./finalizado"><button type="submit" class="btn btn-primary">Finalizar</button></a>
                                    </div> -->
                                    <div class="container-radio">
                                        <form id="radioForm">
                                            <label>
                                                <input type="radio" name="option" value="option1"> Cartão de Credito
                                            </label><br>
                                            <label>
                                                <input type="radio" name="option" value="option2"> Cartão de Debito
                                            </label><br>
                                            <label>
                                                <input type="radio" name="option" value="option3"> Pix
                                            </label><br>
                                            <div class="btn-check-finalizar">
                                                <a href="./finalizado"><button type="button" id="validateButton" disabled>Validar</button></a>
                                            </div>
                                        </form>
                                    </div>

                                </div>
                            </c:otherwise>
                        </c:choose>




                    </section>
                </div>
            </main>

            <footer id="under">
                <div class="content-ft">
                    <div class="contato">
                        <h3 class="title-ft">Contato</h3>
                        <p class="info">Email:</p>
                        <p>soundspacecontato@gmail.com</p>
                        <p class="info">Telefone:</p>
                        <p>(43) 98815-4746</p>
                        <p class="info">Local:</p>
                        <p>Rua Comandante Ismael Guilherme, 15 - California</p>
                    </div>
                    <div class="sobre">
                        <h3 class="title-ft">Sobre</h3>
                        <p>Bem-vindo à SoundSpace, onde excelência sonora encontra facilidade de compra. Oferecemos uma
                            seleção premium de caixas de som e aparelhos de áudio, escolhidos por apaixonados por som.
                            Navegue em nossa loja para descobrir como podemos elevar sua experiência auditiva.</p>
                    </div>
                    <div class="social">
                        <h3 class="title-ft">Social</h3>
                        <i class="bi bi-instagram"></i>
                        <i class="bi bi-whatsapp"></i>
                        <i class="bi bi-linkedin"></i>
                        <i class="bi bi-github"></i>
                        <i class="bi bi-twitter-x"></i>
                    </div>
                </div>
                <div class="text-ft">
                    <span>© SoundSpace – Todos os direitos reservados. 2024</span>
                </div>
            </footer>
        </body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/4f2931e92d.js" crossorigin="anonymous"></script>
        <script src="js/radios-validation.js" type="text/javascript"></script>
        </html>