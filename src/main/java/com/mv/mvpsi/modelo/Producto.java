package com.mv.mvpsi.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String codigo;
    private int cantidad;
    private int stockMinimo;
	private String descripcion;
	private int precio;
	private LocalDateTime fechaCreacion;
	private Boolean estado;

    // Métodos para la lógica de negocio (La Alerta)
    public boolean isAlertaStock() {
        return this.cantidad <= this.stockMinimo;
    }

    // Genera los Getters y Setters aquí (puedes usar tu IDE para autocompletarlos)
}
