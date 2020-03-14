package com.acelera.aula15.escolatecnica.service;

import com.acelera.aula15.escolatecnica.domain.Aluno;
import com.acelera.aula15.escolatecnica.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvar(Aluno aluno) {
        if ((aluno.getNome() == null) || (aluno.getCpf() == null) || (aluno.getDataNascimento() == null) || (aluno.getTelefone() == null)) {
            throw new NullPointerException();
        }

        return alunoRepository.save(aluno);
    }

    public List<Aluno> findByIds(List<Long> idAlunos) {
        return null;
    }
}