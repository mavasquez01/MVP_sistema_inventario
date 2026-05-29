package com.mv.mvpsi.controlador;

import org.springframework.web.bind.annotation.*;

import com.mv.mvpsi.modelo.User;
import com.mv.mvpsi.servicio.UserServicio;

@RestController
@RequestMapping("/api/usuarios")
public class ControladorUser {

    private final UserServicio service;

    public ControladorUser(UserServicio service) {
        this.service = service;
    }

    @PostMapping("/registro")
    public User registrarUsuario(
            @RequestBody User usuario
    ) {
        return service.crearUsuario(usuario);
    }
}