package com.example.myshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myshop.domain.Categoria;
import com.example.myshop.repositories.CategoriaRepository;

@Service
public class CategoriaServiceImplMem implements CategoriaService {

    @Autowired
    public CategoriaRepository categoriaRepository;

    public Categoria añadir(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> obtenerTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria obtenerPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria editar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void borrar(Long id) {
        categoriaRepository.deleteById(id);
    }
}