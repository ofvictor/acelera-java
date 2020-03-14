package com.acelera.aula15.escolatecnica.domain;

import javax.persistence.*;

@Entity
@Table (name = "curso")
public class Curso {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column (name = "descricao")
    private String descricaoCurso;

    @Column (name = "requisitos")
    private String requisitosCurso;

    @Column (name = "modalidade")
    private String modalidadeCurso;

    public Long getId() {
        return id;
    }

    public String getDescricaoCurso() {
        return descricaoCurso;
    }

    public void setDescricaoCurso(String descricaoCurso) {
        this.descricaoCurso = descricaoCurso;
    }

    public String getRequisitosCurso() {
        return requisitosCurso;
    }

    public void setRequisitosCurso(String requisitosCurso) {
        this.requisitosCurso = requisitosCurso;
    }

    public String getModalidadeCurso() {
        return modalidadeCurso;
    }

    public void setModalidadeCurso(String modalidadeCurso) {
        this.modalidadeCurso = modalidadeCurso;
    }
}