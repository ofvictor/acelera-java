package com.acelera.aula15.escolatecnica.repository;

import com.acelera.aula15.escolatecnica.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}