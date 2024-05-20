package com.example.myshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Comentario {
    @Id
    @GeneratedValue
    private Long id;
    private Double puntuacion;
    private String descripcion;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Arma arma;
}