package com.acelera.aula15.escolatecnica.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "aluno")
public class Aluno {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "cpf")
    private String cpf;

    @Column (name = "data_nascimento")
    private String dataNascimento;

    @Column (name = "telefone")
    private String telefone;

    @OneToMany(mappedBy = "aluno")
    private List<Matricula> matriculas;

    public Aluno(String nome, String cpf, String dataNascimento, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public Long getId() { return this.id; }

    public void setNome(String nome) { this.nome = nome; }

    public String getNome() { return this.nome; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCpf() { return this.cpf; }

    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getDataNascimento() { return this.dataNascimento; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getTelefone() { return this.telefone; }
}