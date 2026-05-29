package com.mv.mvpsi.controlador;

import org.springframework.web.bind.annotation.*;
import com.mv.mvpsi.modelo.Estado;
import com.mv.mvpsi.repositorio.RepositorioEstado;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
@CrossOrigin(origins = "*") // Permite que tu frontend se conecte sin problemas de CORS
public class ControladorEstado {

    private final RepositorioEstado repository;

    public ControladorEstado(RepositorioEstado repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Estado> obtenerTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Estado crearEstado(@RequestBody Estado estado) {
        return repository.save(estado);
    }

    @DeleteMapping("/{id}")
    public void eliminarEstado(@PathVariable Long id) {
        repository.deleteById(id);
    }
}