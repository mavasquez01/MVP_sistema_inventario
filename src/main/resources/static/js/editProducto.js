const id = new URLSearchParams(window.location.search)
    .get("id");

const producto = await fetch(`/api/productos/${id}`)
    .then(r => r.json());

document.getElementsByName("id")[0].value = producto.id;
document.getElementsByName("nombre")[0].value = producto.nombre;
document.getElementsByName("descripcion")[0].value = producto.descripcion;
document.getElementsByName("precio")[0].value = producto.precio;
document.getElementsByName("stock")[0].value = producto.cantidad;
document.getElementsByName("fecha")[0].value = producto.fechaCreacion.split("T")[0];

async function registrar() {

    const producto = {
        id: document.getElementById("id").value,
        nombre: document.getElementById("nombre").value,
        descripcion: document.getElementById("descripcion").value,
        precio: document.getElementById("precio").value,
        cantidad: document.getElementById("stock").value,
        fechaCreacion: document.getElementById("fecha").value
    };

    const response = await fetch(`/api/productos/${id}`, {
        method: "PUT",
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

document.getElementById("formularioEditarProducto").addEventListener("submit", function (event) {
    event.preventDefault();
    registrar();
});