package com.example.myshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.myshop.domain.Usuario;
import com.example.myshop.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImplMem implements UsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Usuario añadir(Usuario usuario) {
        if (usuarioRepository.findByNombre(usuario.getNombre()) == null)
            return usuarioRepository.save(usuario);
        return null;
    }

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario obtenerPorNombre(String id) {
        return usuarioRepository.findByNombre(id);
    }

    public void editar(Usuario usuario) {
        Usuario u1 = usuarioRepository.findByNombre(usuario.getNombre());
        u1.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(u1);
    }

    public void borrar(Long id) {
        usuarioRepository.deleteById(id);
    }
}