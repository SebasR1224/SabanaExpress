let cerrar = document.querySelectorAll(".closeSintoma")[0];
let abrir = document.querySelectorAll(".ctaSintoma")[0];
let modal = document.querySelectorAll(".modalSintoma")[0];
let modalC = document.querySelectorAll(".modal-containerSintoma")[0];

abrir.addEventListener("click" , function(e){
    e.preventDefault();
    modalC.style.opacity = "1"
    modalC.style.visibility = "visible"
    modal.classList.toggle("modal-close");
});
cerrar.addEventListener("click" , function(){
    modal.classList.toggle("modal-close")
    setTimeout(function(){
        modalC.style.opacity = "0"
        modalC.style.visibility = "hidden"
    }, 700);
})


let cerrarParte = document.querySelectorAll(".closeParte")[0];
let abrirParte = document.querySelectorAll(".ctaParte")[0];
let modalParte = document.querySelectorAll(".modalParte")[0];
let modalCParte = document.querySelectorAll(".modal-containerParte")[0];

abrirParte.addEventListener("click" , function(e){
    e.preventDefault();
    modalCParte.style.opacity = "1"
    modalCParte.style.visibility = "visible"
    modalParte.classList.toggle("modal-close");
});
cerrarParte.addEventListener("click" , function(){
    modalParte.classList.toggle("modal-close")
    setTimeout(function(){
        modalCParte.style.opacity = "0"
        modalCParte.style.visibility = "hidden"
    }, 700);
})