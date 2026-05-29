package com.mv.mvpsi.repositorio;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mv.mvpsi.modelo.User;

@Repository
public interface RepositorioUser extends JpaRepository<User, Long> {

    Optional<User> findByCorreo(String Correo);
}