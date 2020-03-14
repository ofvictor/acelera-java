package com.acelera.aula15.escolatecnica.service;

import com.acelera.aula15.escolatecnica.domain.Curso;
import com.acelera.aula15.escolatecnica.domain.Turma;
import com.acelera.aula15.escolatecnica.dto.TurmaDTO;
import com.acelera.aula15.escolatecnica.repository.TurmaRepository;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {
    private CursoService cursoService;
    private TurmaRepository turmaRepository;
    private MatriculaService matriculaService;

    public TurmaService(CursoService cursoService, TurmaRepository turmaRepository, MatriculaService matriculaService) {
        this.cursoService = cursoService;
        this.turmaRepository = turmaRepository;
        this.matriculaService = matriculaService;
    }

    public Turma save(TurmaDTO turmaDTO) {
        Curso curso = cursoService.findById(turmaDTO.getIdCurso());
        Turma turma = new Turma(turmaDTO.getDataInicio(),turmaDTO.getDataFinal(),curso);
        Turma turmaSalva = turmaRepository.save(turma);
        matriculaService.save(turmaSalva, turmaDTO.getIdAlunos());
        return turmaSalva;
    }
}