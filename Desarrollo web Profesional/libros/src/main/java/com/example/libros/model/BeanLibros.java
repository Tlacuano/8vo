package com.example.libros.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Table(name = "libros")
@Entity
@NoArgsConstructor
public class BeanLibros {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private String titulo;

    private String autor;

    private String genero;

    private LocalDate fechaPublicacion;
}
