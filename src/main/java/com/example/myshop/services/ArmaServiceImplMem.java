package com.example.myshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Arma editar(Arma arma) {
        return armaRepository.save(arma);
    }

}
