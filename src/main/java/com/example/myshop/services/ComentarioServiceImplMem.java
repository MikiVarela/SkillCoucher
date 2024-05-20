package com.example.myshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.myshop.domain.Arma;
import com.example.myshop.domain.Usuario;
import com.example.myshop.domain.Comentario;
import com.example.myshop.repositories.ComentarioRepository;

@Service
public class ComentarioServiceImplMem implements ComentarioService {

    @Autowired
    public ComentarioRepository comentarioRepository;

    public Comentario añadir(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> obtenerTodosPorUsuario(Usuario usuario) {
        return comentarioRepository.findByUsuario(usuario);
    }

    public List<Comentario> obtenerTodosPorArma(Arma arma) {
        return comentarioRepository.findByArma(arma);
    }

    public Comentario obtenerPorId(Long id) {
        return comentarioRepository.findById(id).orElse(null);
    }

    public Comentario editar(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public void borrar(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            if (currentUserName == obtenerPorId(id).getUsuario().getNombre())
            comentarioRepository.deleteById(id);
        }
    }
}