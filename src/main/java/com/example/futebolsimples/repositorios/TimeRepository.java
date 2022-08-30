package com.example.futebolsimples.repositorios;

import com.example.futebolsimples.entidades.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
}
