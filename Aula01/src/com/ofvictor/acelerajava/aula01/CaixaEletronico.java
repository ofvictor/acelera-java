package com.ofvictor.acelerajava.aula01;

import java.text.NumberFormat;
import java.util.Scanner;

public class CaixaEletronico {
	
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        double[] cedulasDisponiveis = {100.0, 50.0, 20.0, 10.0};
        
        int[] quantidadeCedulasNoCaixa = {10, 10, 10, 10};
        
        int[] quantidadeCedulasAEntregar = new int[4];
        
        boolean temCedulasSuficientes = true;
        
        do {
            for (int i = 0; i < quantidadeCedulasNoCaixa.length; i++) {
                System.out.println("Cédulas de " + NumberFormat.getCurrencyInstance().format(cedulasDisponiveis[i]) + ": " + quantidadeCedulasNoCaixa[i]);
            }
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe o valor a ser sacado: ");
            double valorASacar = sc.nextDouble();
            
            if (valorASacar % 10.0 != 0) {
                System.out.println("Valor solicitado precisa ser múltiplo da menor cédula disponível (" + NumberFormat.getCurrencyInstance().format(cedulasDisponiveis[cedulasDisponiveis.length-1]) + ").");
                return;
            }
            
            double quantiaDisponivel = 0.0;
            for (int i = 0; i < cedulasDisponiveis.length; i++) {
                quantiaDisponivel += cedulasDisponiveis[i] * quantidadeCedulasNoCaixa[i];
                quantidadeCedulasAEntregar[i] = 0;
            }
            
            if (valorASacar > quantiaDisponivel) {
                System.out.println("Valor solicitado excede a quantia disponível (" + quantiaDisponivel + ").");
                temCedulasSuficientes = false;
                continue;
            }
            
            double valorEmDecomposicao = valorASacar;
            
            for (int i = 0; i < quantidadeCedulasAEntregar.length; i++) {
                if (quantidadeCedulasNoCaixa[i] > 0) {
                    quantidadeCedulasAEntregar[i] = (int) (valorEmDecomposicao / cedulasDisponiveis[i]);
                    
                    if (quantidadeCedulasAEntregar[i] <= quantidadeCedulasNoCaixa[i]) {
                        valorEmDecomposicao %= cedulasDisponiveis[i];
                        quantidadeCedulasNoCaixa[i] -= quantidadeCedulasAEntregar[i];
                    } else {
                    	quantidadeCedulasAEntregar[i] = quantidadeCedulasNoCaixa[i];
                    	quantidadeCedulasNoCaixa[i] = 0;
                    	valorEmDecomposicao -=  quantidadeCedulasAEntregar[i] * cedulasDisponiveis[i];
                    }
                }
            }
            
            for (int i = 0; i < quantidadeCedulasAEntregar.length; i++) {
                System.out.println("Quantidade de notas de " + NumberFormat.getCurrencyInstance().format(cedulasDisponiveis[i]) + ": " + quantidadeCedulasAEntregar[i]);
            }
        } while (temCedulasSuficientes);
    }
}