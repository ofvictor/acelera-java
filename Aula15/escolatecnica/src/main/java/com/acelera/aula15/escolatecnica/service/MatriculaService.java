package com.acelera.aula15.escolatecnica.service;

import com.acelera.aula15.escolatecnica.domain.Turma;
import com.acelera.aula15.escolatecnica.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {
    private MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public void save(Turma turma, List<Long> idAlunos) {
    }
}