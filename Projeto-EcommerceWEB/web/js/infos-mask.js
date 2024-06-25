function formatarValor(valor) {
    return valor.toFixed(2).replace('.', ',');
}

window.onload = function() {
    const valorElemento = document.getElementById('produto-valor');
    const valor = parseFloat(valorElemento.innerText);
    valorElemento.innerText = "R$ " + formatarValor(valor);
};
