package com.example.libros.model;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface LibrosRepository extends JpaRepository<BeanLibros, Integer>{
}
