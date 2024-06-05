package com.example.myshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myshop.domain.Categoria;
import com.example.myshop.domain.Sky;
import com.example.myshop.repositories.CategoriaRepository;
import com.example.myshop.repositories.SkyRepository;
import com.example.myshop.repositories.ArmaRepository;

@Service
public class SkyServiceImplMem implements SkyService {
    @Autowired
    SkyRepository skyRepository;
    @Autowired
    CategoriaRepository categoriaRepository;

    public Sky añadir(Sky sky) {
        return skyRepository.save(sky);
    }

    public List<Sky> obtenerTodos() {
        return skyRepository.findAll();
    }

    public Sky editar(Sky sky) {
        return skyRepository.save(sky);
    }

}
