package com.acelera.aula15.escolatecnica.domain;

import javax.persistence.*;

@Entity
@Table (name = "matricula")
public class Matricula {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "id_turma")
    private Long idTurma;

    @Column(name = "id_aluno")
    private Long idAluno;

    public Long getId() {
        return id;
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }
}
