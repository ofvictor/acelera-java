package com.ofvictor.acelerajava.aula02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorAlunos {
	
    private static List<Aluno> LISTA_ALUNOS = new ArrayList<Aluno>();
    
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        int opcao = 0;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Delimitador: " + scanner.delimiter() + ".");
        
        do {
            System.out.println("Escolha dentre as opções a seguir: (1) Cadastra aluno (2) Lista os alunos cadastrados (9) Sair");
            
            opcao = scanner.nextInt();
            
            if (opcao == 1) {
                System.out.println("Informe o nome do aluno: ");
                String nome = scanner.next();
                if ((nome == null) || (nome.trim().equals(""))) {
                    System.out.println("Nome não pode ser nulo.");
                    continue;
                }
                
                System.out.println("Informe a idade do aluno: ");
                int idade = scanner.nextInt();
                if (idade < 10 || idade > 18){
                    System.out.println("Idade do aluno deve ser entre 10 e 18 anos.");
                    continue;
                }
                
                System.out.println("Informe o documento do aluno: ");
                String documento = scanner.next();
                if ((documento == null) || (documento.trim().length() < 10)) {
                    System.out.println("Documento não pode ser nulo e deve conter no minimo 10 caracteres.");
                    continue;
                }
                
                GerenciadorAlunos.LISTA_ALUNOS.add(new Aluno(nome,idade,documento));
                
            } else if (opcao == 2) {
                if (GerenciadorAlunos.LISTA_ALUNOS.size() == 0) {
                    System.out.println("Não há alunos cadastrados.");
                } else {
                    for (Aluno aluno : GerenciadorAlunos.LISTA_ALUNOS) {
                        System.out.println("[Aluno] Nome: " + aluno.getNome() + " | Idade: " + aluno.getIdade() + " | Documento: " + aluno.getDocumento());
                    }
                }
            }
        } while (opcao != 9);
        
        scanner.close();
    }
}