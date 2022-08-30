package com.example.futebolsimples.repositorios;

import com.example.futebolsimples.entidades.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidaRepository extends JpaRepository<Partida, Long> {
}
