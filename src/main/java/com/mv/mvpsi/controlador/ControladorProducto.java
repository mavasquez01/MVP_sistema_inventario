package com.mv.mvpsi.controlador;

import org.springframework.web.bind.annotation.*;
import com.mv.mvpsi.modelo.Producto;
import com.mv.mvpsi.repositorio.RepositorioProducto;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*") // Permite que tu frontend se conecte sin problemas de CORS
public class ControladorProducto {

    private final RepositorioProducto repository;

    // Inyección de dependencias por constructor
    public ControladorProducto(RepositorioProducto repository) {
        this.repository = repository;
    }

    // 1. Obtener todos los productos
    @GetMapping
    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    // 2. Guardar un nuevo producto
    @HttpsPost
    public Producto crearProducto(@RequestBody Producto producto) {
        return repository.save(producto);
    }

    // 3. Eliminar un producto
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        repository.deleteById(id);
    }
}