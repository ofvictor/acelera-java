package com.acelera.aula15.escolatecnica.service;

import com.acelera.aula15.escolatecnica.domain.Curso;
import com.acelera.aula15.escolatecnica.repository.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso salvar(Curso curso) {
        if ((curso.getNome() == null) || (curso.getDescricao() == null) || (curso.getRequisitos() == null) || (curso.getModalidade() == null)) {
            throw new NullPointerException();
        }

        return cursoRepository.save(curso);
    }

    public Curso findById(Long idCurso) {
        return null;
    }
}