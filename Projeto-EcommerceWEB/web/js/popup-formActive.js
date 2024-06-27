let popup = document.querySelector(".popup");
let formOpen3 = document.querySelector("#perfil-btn3");
let formClose2 = document.querySelector(".close-form2");

formOpen3.addEventListener("click", ()=> {
    popup.classList.add("active")
})

formClose2.addEventListener("click", ()=> {
    popup.classList.remove("active")
})