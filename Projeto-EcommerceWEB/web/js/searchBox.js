let searchBox = document.querySelector('.input-content');
let lupa = document.querySelector('.btn-search');
let fechar = document.querySelector('.btn-close');

    lupa.addEventListener('click', ()=> {
        searchBox.classList.add('ativar')
    })

fechar.addEventListener('click', ()=> {
    searchBox.classList.remove('ativar')
})