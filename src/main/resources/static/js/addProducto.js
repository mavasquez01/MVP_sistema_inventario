async function addProd() {

    const producto = {
        nombre: document.getElementById("nombre").value,
        descripcion: document.getElementById("descripcion").value,
        precio: parseFloat(document.getElementById("precio").value),
        cantidad: parseInt(document.getElementById("stock").value),
        fechaCreacion: document.getElementById("fecha").value,
        estado: { id: 1}
    };

    const response = await fetch(`/api/productos`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(producto)
    });

    if (response.ok) {
        window.location.href = "/productos.html";
    } else {
        const alertaError = document.getElementById("alertaError");
        alertaError.classList.remove("d-none");
    }
};

document.getElementById("formProducto").addEventListener("submit", function (event) {
    event.preventDefault();
    addProd();
});