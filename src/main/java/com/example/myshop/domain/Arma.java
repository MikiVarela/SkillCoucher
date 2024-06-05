package com.example.myshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Arma {
    @Id
    private String id;
    private String name;
    private String image;
    private String description;
    private String type;
    // private AttackPower[] attackPower;
}