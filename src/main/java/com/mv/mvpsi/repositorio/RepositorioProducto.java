package com.mv.mvpsi.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mv.mvpsi.modelo.Producto;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long> {
    
}