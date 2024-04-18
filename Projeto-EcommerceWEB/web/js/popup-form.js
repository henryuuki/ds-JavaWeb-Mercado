let popup = document.querySelector(".popup");
let formOpen = document.querySelector("#perfil-btn");
let formClose = document.querySelector(".close-form");

formOpen.addEventListener("click", ()=> {
    popup.classList.add("active")
})

formClose.addEventListener("click", ()=> {
    popup.classList.remove("active")
})