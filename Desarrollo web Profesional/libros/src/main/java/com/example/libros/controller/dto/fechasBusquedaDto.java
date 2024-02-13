package com.example.libros.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class fechasBusquedaDto {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
