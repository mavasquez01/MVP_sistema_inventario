const id = new URLSearchParams(window.location.search)
    .get("id");
console.log("ID del producto a editar:", id);

async function cargarProducto() {
    const producto = await fetch(`/api/productos/${id}`)
        .then(r => r.json());
    console.log("Producto obtenido:", producto);

    document.getElementById("nombre").value = producto.nombre;
    document.getElementById("descripcion").value = producto.descripcion;
    document.getElementById("precio").value = producto.precio;
    document.getElementById("stock").value = producto.cantidad;
    document.getElementById("fecha").value = producto.fechaCreacion;
 }

async function updateProd() {

    const productoActualizado = {
        id: id,
        nombre: document.getElementById("nombre").value,
        descripcion: document.getElementById("descripcion").value,
        precio: parseFloat(document.getElementById("precio").value),
        cantidad: parseInt(document.getElementById("stock").value),
        fechaCreacion: document.getElementById("fecha").value,
        estado: { id: 1}
    };
    console.log("Producto actualizado a enviar:", productoActualizado);

    const response = await fetch(`/api/productos/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(productoActualizado)
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
    updateProd();
});

document.addEventListener("DOMContentLoaded", cargarProducto);