package com.example.myshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myshop.domain.Over;
import com.example.myshop.repositories.CategoriaRepository;
import com.example.myshop.repositories.OverRepository;

@Service
public class OverServiceImplMem implements OverService {
    @Autowired
    OverRepository overRepository;
    @Autowired
    CategoriaRepository categoriaRepository;

    public Over añadir(Over over) {
        return overRepository.save(over);
    }

    public List<Over> obtenerTodos() {
        return overRepository.findAll();
    }
    public Over obtenerPorId(Long id) {
        return overRepository.findById(id).orElse(null);
    }

    public Over editar(Over over) {
        return overRepository.save(over);
    }

    public void borrar(Long id) {
        overRepository.deleteById(id);
    }
}
