package com.example.myshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myshop.domain.Sky;
import com.example.myshop.repositories.CategoriaRepository;
import com.example.myshop.repositories.SkyRepository;

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

    public Sky obtenerPorId(Long id) {
        return skyRepository.findById(id).orElse(null);
    }

    public Sky editar(Sky sky) {
        return skyRepository.save(sky);
    }

    public void borrar(Long id) {
        skyRepository.deleteById(id);
    }


}
