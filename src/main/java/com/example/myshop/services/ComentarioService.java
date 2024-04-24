package com.example.myshop.services;

import java.util.List;

import com.example.myshop.domain.Arma;
import com.example.myshop.domain.Usuario;
import com.example.myshop.domain.Comentario;

public interface ComentarioService {
    Comentario añadir(Comentario Valoracion);

    List<Comentario> obtenerTodosPorUsuario(Usuario usuario);

    List<Comentario> obtenerTodosPorArma(Arma producto);

    Comentario obtenerPorId(Long id);

    Comentario editar(Comentario usuario);

    void borrar(Long id);
}