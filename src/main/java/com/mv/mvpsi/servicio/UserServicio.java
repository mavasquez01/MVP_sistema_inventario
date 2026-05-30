package com.mv.mvpsi.servicio;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mv.mvpsi.modelo.User;
import com.mv.mvpsi.repositorio.RepositorioUser;

@Service
public class UserServicio {

    private final RepositorioUser repository;
    private final PasswordEncoder passwordEncoder;

    public UserServicio(
            RepositorioUser repository,
            PasswordEncoder passwordEncoder
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User crearUsuario(User usuario) {

        if (repository.findByCorreo(usuario.getCorreo()).isPresent()) {
        throw new RuntimeException("El correo ya está registrado");
    }

        usuario.setContrasena(
                passwordEncoder.encode(usuario.getContrasena())
        );

        usuario.setRol("USER");

        return repository.save(usuario);
    }
}