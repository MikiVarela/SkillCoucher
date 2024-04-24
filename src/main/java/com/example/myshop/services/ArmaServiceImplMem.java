package com.example.myshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myshop.domain.Categoria;
import com.example.myshop.domain.Arma;
import com.example.myshop.repositories.CategoriaRepository;
import com.example.myshop.repositories.ArmaRepository;

@Service
public class ArmaServiceImplMem implements ArmaService {
    @Autowired
    ArmaRepository armaRepository;
    @Autowired
    CategoriaRepository categoriaRepository;

    public Arma añadir(Arma arma) {
        return armaRepository.save(arma);
    }

    public List<Arma> obtenerTodos() {
        return armaRepository.findAll();
    }

    public Arma obtenerPorId(Long id) {
        return armaRepository.findById(id).orElse(null);
    }

    public Arma editar(Arma arma) {
        return armaRepository.save(arma);
    }

    public void delete(Long id) {
        armaRepository.deleteById(id);
    }

    public List<Arma> obtenerPorCategoria(Long idCategoria) {
        Categoria categoria = categoriaRepository.findById(idCategoria).orElse(null);
        if (categoria == null)
            return null;
        return armaRepository.findByCategoria(categoria);
    }
}
