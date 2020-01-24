package com.ofvictor.acelera_java.aula05.business;

import com.ofvictor.acelera_java.aula05.exception.*;

public class Locadora {
    private String[] VEICULO = {"Passeio","SUV","Caminhonete","Moto"};
    
    public double locaVeiculo(int qtdDias, String tipoVeiculo) {
        if (qtdDias <= 0) {
            throw new ParametroLocacaoException("Número de dias da locação deve ser um número positivo e maior que zero.");
        }
        
        if (tipoVeiculo == null) {
            throw new ParametroLocacaoException("O tipo de veículo deve ser informado.");
        }
        
        int posicaoVeiculo = -1;
        
        for (int i = 0; i < VEICULO.length ; i++) {
            if (tipoVeiculo.equals(VEICULO[i])) {
                posicaoVeiculo = i;
                break;
            }
        }
        
        if (posicaoVeiculo < 0) {
            throw new ParametroLocacaoException("Favor informar um tipo de veículo válido.");
        }
        
        Veiculo veiculo = null;
        
        switch (tipoVeiculo) {
            case "Passeio":
                veiculo = new Passeio();
                break;
            case "SUV":
                veiculo = new SUV();
                break;
            case "Caminhonete":
                veiculo = new Caminhonete();
                break;
            case "Moto":
                veiculo = new Moto();
                break;
        }
        
        double custoLocacao = veiculo.locaVeiculo(qtdDias);
        
        if (qtdDias > 10) {
            custoLocacao *= 1.20;
        } else if (qtdDias > 5) {
            custoLocacao *= 1.10;
        } else {
            custoLocacao *= 1.05;
        }
        
        return custoLocacao;
    }
}