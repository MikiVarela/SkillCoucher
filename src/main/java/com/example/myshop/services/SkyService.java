package com.example.myshop.services;

import java.util.List;

import com.example.myshop.domain.Sky;

public interface SkyService {
    Sky añadir(Sky sky);

    List<Sky> obtenerTodos();

    Sky obtenerPorId(Long id);

    Sky editar(Sky sky);

    void borrar(Long id);

}
