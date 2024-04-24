package com.example.myshop.services;

import java.util.List;

import com.example.myshop.domain.Usuario;

public interface UsuarioService {
    Usuario añadir(Usuario usuario);

    List<Usuario> obtenerTodos();

    Usuario obtenerPorId(Long id);

    public Usuario obtenerPorNombre(String id);

    void editar(Usuario usuario);

    void borrar(Long id);
}