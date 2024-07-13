package com.auraderm_db.AuraDerm2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String descripcion;

    @Column(length = 35)
    private String nombre;

    @Column(precision = 10, scale = 2)
    private BigDecimal precio;

    private int stock;

    @Column(length = 50)
    private String categoria;

    public Producto(String descripcion, String nombre, BigDecimal precio, int stock, String categoria) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }
}