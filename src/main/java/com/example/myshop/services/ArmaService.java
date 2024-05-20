package com.example.myshop.services;

import java.util.List;

import com.example.myshop.domain.Arma;

public interface ArmaService {
    Arma añadir(Arma producto);

    List<Arma> obtenerTodos();

    Arma obtenerPorId(Long id);

    Arma editar(Arma producto);

    void delete(Long id);

    List<Arma> obtenerPorCategoria(Long idCategoria);

}
