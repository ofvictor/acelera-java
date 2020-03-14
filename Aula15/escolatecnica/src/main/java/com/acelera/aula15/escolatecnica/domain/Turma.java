package com.acelera.aula15.escolatecnica.domain;

import javax.persistence.*;

@Entity
@Table(name = "turma")
public class Turma {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column (name = "id_curso")
    private Long idCurso;

    @Column (name = "data_ini")
    private String dtIniTurma;

    @Column (name = "data_fim")
    private String dtFimTurma;

    public Long getId() {
        return id;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getDtIniTurma() {
        return dtIniTurma;
    }

    public void setDtIniTurma(String dtIniTurma) {
        this.dtIniTurma = dtIniTurma;
    }

    public String getDtFimTurma() {
        return dtFimTurma;
    }

    public void setDtFimTurma(String dtFimTurma) {
        this.dtFimTurma = dtFimTurma;
    }
}