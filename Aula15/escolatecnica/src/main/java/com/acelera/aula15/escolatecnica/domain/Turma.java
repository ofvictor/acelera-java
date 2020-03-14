package com.acelera.aula15.escolatecnica.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "turma")
public class Turma {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column (name = "data_ini")
    private String dataIni;

    @Column (name = "data_fim")
    private String dataFim;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
    private Curso curso;

    @OneToMany(mappedBy = "turma")
    private List<Matricula> matriculas;

    public Turma(String dataIni, String dataFim, Curso curso) {
        this.dataIni = dataIni;
        this.dataFim = dataFim;
        this.curso = curso;
    }

    public Long getId() { return id; }

    public void setDataIni(String dataIni) { this.dataIni = dataIni; }

    public String getDataIni() { return dataIni; }

    public void setDataFim(String dataFim) { this.dataFim = dataFim; }

    public String getDataFim() { return this.dataFim; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (getClass() != o.getClass())) return false;

        Turma turma = (Turma) o;
        return Objects.equals(this.id, turma.id) &&
                Objects.equals(this.dataIni, turma.dataIni) &&
                Objects.equals(this.dataFim, turma.dataFim) &&
                Objects.equals(this.curso, turma.curso) &&
                Objects.equals(this.matriculas, turma.matriculas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.dataIni, this.dataFim, this.curso, this.matriculas);
    }
}