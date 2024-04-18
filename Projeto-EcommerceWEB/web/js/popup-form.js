document.querySelector("perfil-btn").addEventListener("click",function(){
    document.querySelector(".popup").classList.add("active");
});

document.querySelector(".popup .close-form").addEventListener("click", function(){
    document.querySelector(".popup").classList.remove("active");
});