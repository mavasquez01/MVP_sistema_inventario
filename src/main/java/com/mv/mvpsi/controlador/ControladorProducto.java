package com.mv.mvpsi.controlador;

import org.springframework.web.bind.annotation.*;

import com.mv.mvpsi.modelo.Estado;
import com.mv.mvpsi.modelo.Producto;
import com.mv.mvpsi.repositorio.RepositorioEstado;
import com.mv.mvpsi.repositorio.RepositorioProducto;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ControladorProducto {

    private final RepositorioProducto repository;
    private final RepositorioEstado repositoryEstado;

    public ControladorProducto(RepositorioProducto repository, RepositorioEstado repositoryEstado) {
        this.repository = repository;
        this.repositoryEstado = repositoryEstado;
    }


    @GetMapping
    public List<Producto> obtenerTodos() { 
        Estado estado = repositoryEstado.findById(1L).orElseThrow();
        return repository.findByEstado(estado);
    }


    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return repository.save(producto);
    }

    @DeleteMapping("/{id}")
    public void desactivarProducto(@PathVariable Long id) {
        //Encontramos el objeto a modificar en la BDD y el traemos el objeto estado de id 2 (desactivado))
        Producto producto = repository.findById(id).orElseThrow();
        Estado estado = repositoryEstado.findById(2L).orElseThrow(); 
        //Modificamos el estado del objeto
        producto.setEstado(estado); 
        //Guardamos a BDD
        repository.save(producto); 

    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(
            @PathVariable Long id,
            @RequestBody Producto productoActualizado) {

        Producto producto = repository.findById(id).orElseThrow();
        Estado estado = repositoryEstado.findById(productoActualizado.getEstado().getId()).orElseThrow();

        
        producto.setNombre(productoActualizado.getNombre());
        producto.setDescripcion(productoActualizado.getDescripcion());
        producto.setPrecio(productoActualizado.getPrecio());
        producto.setCantidad(productoActualizado.getCantidad());
        producto.setFechaCreacion(productoActualizado.getFechaCreacion());
        producto.setEstado(estado);

        return repository.save(producto);
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

}