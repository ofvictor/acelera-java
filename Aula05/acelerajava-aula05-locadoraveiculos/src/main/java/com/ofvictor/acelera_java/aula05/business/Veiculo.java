package com.ofvictor.acelera_java.aula05.business;

public class Veiculo {
    protected double valorDiaria = 0.0;
    
    public Double getDiaria() {
        return valorDiaria;
    }
    
    public Double locaVeiculo(int qtdDias) {
        return this.getDiaria() * qtdDias;
    }
}