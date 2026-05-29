package com.mv.mvpsi.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mv.mvpsi.modelo.Estado;

@Repository
public interface RepositorioEstado extends JpaRepository<Estado, Long> {
    
}