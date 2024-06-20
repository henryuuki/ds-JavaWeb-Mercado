let popup = document.querySelector(".popup");
let formOpen1 = document.querySelector("#perfil-btn1");
let formOpen2 = document.querySelector("#perfil-btn2");
let formClose = document.querySelector(".close-form");

formOpen1.addEventListener("click", ()=> {
    popup.classList.add("active")
})

formOpen2.addEventListener("click", ()=> {
    popup.classList.add("active")
})

formClose.addEventListener("click", ()=> {
    popup.classList.remove("active")
})