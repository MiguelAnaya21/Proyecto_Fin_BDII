/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dosideas.fidelizacion.service;

import com.dosideas.fidelizacion.domain.Categoria;
import com.dosideas.fidelizacion.repository.CategoriaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author migue
 */
@Service
public class CategoriaService {
    
    //Hace un objeto tipo categoriaRepository
    private final CategoriaRepository categoriaRepository;

    //Realiza un Constructor para el Service
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    
    //Hace una lista de todos las encontradas en la BD
    public List<Categoria> buscarTodos(){
        return categoriaRepository.findAll();
    }
}

