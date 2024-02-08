package com.example.libros.model;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface LibrosRepositoryPaginator extends PagingAndSortingRepository<BeanLibros, Integer>{
}
