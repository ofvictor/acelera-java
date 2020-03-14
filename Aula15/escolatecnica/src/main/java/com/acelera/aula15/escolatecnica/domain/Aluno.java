package com.acelera.aula15.escolatecnica.domain;

import javax.persistence.*;

@Entity
@Table (name = "aluno")
public class Aluno {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column (name = "cpf")
    private String cpf;

    @Column (name = "data_nascimento")
    private String dataNascimento;

    @Column (name = "telefone")
    private String telefone;

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}