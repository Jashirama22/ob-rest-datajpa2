package com.example.obrestdatajpa.repositorios;

import com.example.obrestdatajpa.entidades.Computadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputadoraReposity extends JpaRepository<Computadora,Long> {
}
