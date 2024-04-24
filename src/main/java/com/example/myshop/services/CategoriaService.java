package com.example.myshop.services;

import java.util.List;

import com.example.myshop.domain.Categoria;

public interface CategoriaService {
    Categoria añadir(Categoria categoria);

    List<Categoria> obtenerTodos();

    Categoria obtenerPorId(Long id);

    Categoria editar(Categoria categoria);

    void borrar(Long id);
}