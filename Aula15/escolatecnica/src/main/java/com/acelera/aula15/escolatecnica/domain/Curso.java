package com.acelera.aula15.escolatecnica.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "curso")
public class Curso {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column (name = "descricao")
    private String descricao;

    @Column (name = "requisitos")
    private String requisitos;

    @Column (name = "modalidade")
    private ModalidadeEnum modalidade;

    @OneToMany(mappedBy = "curso")
    private List<Turma> turmas;

    public Curso(String nome, String descricao, String requisitos, ModalidadeEnum modalidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.requisitos = requisitos;
        this.modalidade = modalidade;
    }

    public Long getId() { return this.id; }

    public void setNome(String nome) { this.nome = nome; }

    public String getNome() { return this.nome; }

    public void setModalidade(ModalidadeEnum modalidade) { this.modalidade = modalidade; }

    public ModalidadeEnum getModalidade() { return this.modalidade; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getDescricao() { return this.descricao; }

    public void setRequisitos(String requisitos) { this.requisitos = requisitos; }

    public String getRequisitos() { return this.requisitos; }
}