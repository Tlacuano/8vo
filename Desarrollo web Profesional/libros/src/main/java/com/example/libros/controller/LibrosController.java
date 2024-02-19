package com.example.libros.controller;

import com.example.libros.controller.dto.fechasBusquedaDto;
import com.example.libros.model.BeanLibros;
import com.example.libros.model.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = {"*"})
public class LibrosController {

    @Autowired
    private LibrosRepository librosRepository;

    @GetMapping("/getAll")
    Page<BeanLibros> getAllLibros(Pageable pageable){
        return librosRepository.findAll(pageable);
    }

    @PostMapping("/getOne")
    BeanLibros getOneLibro(@RequestBody BeanLibros libro){
        return librosRepository.findById(libro.getId()).get();
    }

    @PostMapping("/save")
    private BeanLibros saveLibro(@RequestBody BeanLibros libro){
        return librosRepository.saveAndFlush(libro);
    }

    @PostMapping("/delete")
    private void deleteLibro(@RequestBody BeanLibros libro){
        librosRepository.delete(libro);
    }

    @PostMapping("/update")
    private BeanLibros updateLibro(@RequestBody BeanLibros libro){
        return librosRepository.save(libro);
    }

    @GetMapping("/getGenero")
    private List<String> getGenero(){
        return librosRepository.findGenero();
    }

    @PostMapping("/findByTitulo")
    Page<BeanLibros> getByTitulo(Pageable pageable,@RequestBody BeanLibros libros){
        libros.setTitulo("%"+libros.getTitulo()+"%");
        return librosRepository.findByTituloLike(libros.getTitulo(), pageable);
    }

    @PostMapping("/findByAutor")
    Page<BeanLibros> getByAutor(Pageable pageable,@RequestBody BeanLibros libros){
        libros.setAutor("%"+libros.getAutor()+"%");
        return librosRepository.findByAutorLike(libros.getAutor(), pageable);
    }

    @PostMapping("/findByGenero")
    Page<BeanLibros> getByGenero(Pageable pageable,@RequestBody BeanLibros libros){
        libros.setGenero("%"+libros.getGenero()+"%");
        return librosRepository.findByGeneroLike(libros.getGenero(), pageable);
    }

    @PostMapping("/findByFechaPublicacion")
    Page<BeanLibros> getByFechaPublicacion(Pageable pageable,@RequestBody fechasBusquedaDto fechas){
        return librosRepository.findByFechaPublicacionBetween(fechas.getFechaInicio(), fechas.getFechaFin(), pageable);
    }

    @GetMapping("/getOrderByFechaPublicacion")
    Page<BeanLibros> getOrderByFechaPublicacion(Pageable pageable){
        return librosRepository.findByOrderByFechaPublicacionDesc(pageable);
    }
}
