package com.example.myshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myshop.domain.Categoria;
import com.example.myshop.domain.AttackPower;

public interface AttackPowerRepository extends JpaRepository<AttackPower, String> {


}