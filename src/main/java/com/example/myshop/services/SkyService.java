package com.example.myshop.services;

import java.util.List;

import com.example.myshop.domain.Sky;

public interface SkyService {
    Sky añadir(Sky producto);

    List<Sky> obtenerTodos();

    Sky editar(Sky producto);



}
