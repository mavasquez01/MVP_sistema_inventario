console.log("registro.js cargado");
async function registrar() {
    console.log("Entrando a registrar");
    const usuario = {
        correo: document.getElementById("correo").value,
        contrasena: document.getElementById("password").value
    };
    console.log(usuario);
    const response = await fetch("/api/usuarios/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(usuario)
    });
    console.log(JSON.stringify(usuario));

    if (response.ok) {
        window.location.href = "/index.html";
    } else {
        const alertaError = document.getElementById("alertaError");
        alertaError.classList.remove("d-none");
    }
};


document.getElementById("formularioRegistro").addEventListener("submit", function (event) {
    event.preventDefault();
    console.log("Submit detectado");
    registrar();
});