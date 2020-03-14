package com.acelera.aula15.escolatecnica.domain;

import javax.persistence.*;

@Entity
@Table (name = "matricula")
public class Matricula {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
    private Turma turma;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
    private Aluno aluno;
}