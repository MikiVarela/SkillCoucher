package com.example.myshop.services;

import java.util.List;

import com.example.myshop.domain.Over;

public interface OverService {
    Over añadir(Over over);

    List<Over> obtenerTodos();

    Over obtenerPorId(Long id);

    Over editar(Over over);

    void borrar(Long id);

}
