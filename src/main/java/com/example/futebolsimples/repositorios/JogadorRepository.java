package com.example.futebolsimples.repositorios;

import com.example.futebolsimples.entidades.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    @Query(value = "select * from jogador where gols_marcados <> 0 order by gols_marcados desc", nativeQuery = true)
    List<Jogador> findByGolsMarcadosDesc();

    Optional<Jogador> findByNome(String nome);
}
