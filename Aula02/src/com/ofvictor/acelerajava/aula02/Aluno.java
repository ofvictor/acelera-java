package com.ofvictor.acelerajava.aula02;

public class Aluno {
    private String nome;
    private  int idade;
    private  String documento;
    
    public Aluno(String nome, int idade, String documento) {
        this.nome = nome;
        this.idade = idade;
        this.documento = documento;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public String getDocumento() {
        return documento;
    }
}