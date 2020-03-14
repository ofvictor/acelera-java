package com.acelera.aula15.escolatecnica.repository;

import com.acelera.aula15.escolatecnica.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}