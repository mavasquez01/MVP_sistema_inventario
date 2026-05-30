async function registrar() {

    const usuario = {
        correo: document.getElementById("correo").value,
        contrasena: document.getElementById("contrasena").value
    };

    const response = await fetch("/api/usuarios/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(usuario)
    });

    if (response.ok) {
        window.location.href = "/productos.html";
    } else {
        const alertaError = document.getElementById("alertaError");
        alertaError.classList.remove("d-none");
    }
};


document.getElementById("formularioRegistro").addEventListener("submit", function (event) {
    event.preventDefault();
    registrar();
});