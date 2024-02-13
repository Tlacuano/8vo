package com.example.libros.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LibrosRepository extends JpaRepository<BeanLibros, Integer>{
    Page<BeanLibros> findByTituloLike (String titulo, Pageable pageable);

    Page<BeanLibros> findByAutorLike (String autor, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT DISTINCT genero FROM libros")
    List<String> findGenero();

    Page<BeanLibros> findByGeneroLike (String genero, Pageable pageable);
    Page<BeanLibros> findByFechaPublicacionBetween (LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable);

    Page<BeanLibros> findByOrderByFechaPublicacionDesc(Pageable pageable);

}
