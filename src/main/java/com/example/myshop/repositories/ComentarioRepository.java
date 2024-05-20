package com.example.myshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myshop.domain.Usuario;
import com.example.myshop.domain.Arma;
import com.example.myshop.domain.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByUsuario(Usuario usuario);
    List<Comentario> findByArma(Arma arma);
}
