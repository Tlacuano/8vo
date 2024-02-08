package com.example.libros.controller;

import com.example.libros.model.BeanLibros;
import com.example.libros.model.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "*")
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

}
