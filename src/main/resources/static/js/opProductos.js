async function cargarProductos() {
    const response = await fetch("/api/productos");
    if (!response.ok) {
        throw new Error(`Respuesta API: ${response.status}`);
    }
    const productos = await response.json();
    const tbody = document.getElementById("cuerpoTablaProductos");

    tbody.innerHTML = "";
    productos.forEach(producto => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${producto.id}</td>
            <td>${producto.nombre}</td>
            <td>${producto.cantidad}</td>
            <td>${producto.descripcion}</td>
            <td>${producto.precio}</td>
            <td>${producto.fechaCreacion}</td>
            <td>
            <button class="btn btn-warning" onClick="editarProducto(${producto.id})">Editar</button>
            <button class="btn btn-danger" onClick="eliminarProducto(${producto.id})">Eliminar</button>
            </td>
        `;
        tbody.appendChild(row);
    });
}

function editarProducto(id) {
    window.location.href = `/formEditProducto.html?id=${id}`;
}

async function eliminarProducto(id) {

    const response = await fetch(`/api/productos/${id}`, {
        method: "DELETE"
    });

    if (response.ok) {
        cargarProductos();
    } else {
        alert("Error al eliminar producto");
    }

    cargarProductos();
}
        
document.addEventListener("DOMContentLoaded", function () {
    cargarProductos();
});