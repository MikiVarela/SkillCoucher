package com.example.myshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myshop.domain.Categoria;
import com.example.myshop.domain.Arma;

public interface ArmaRepository extends JpaRepository<Arma, Long> {

    List<Arma> findByCategoria(Categoria categoria);

}