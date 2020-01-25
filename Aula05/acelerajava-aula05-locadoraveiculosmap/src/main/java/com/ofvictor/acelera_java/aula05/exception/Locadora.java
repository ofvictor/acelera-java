package com.ofvictor.acelera_java.aula05.exception;

import java.util.HashMap;
import java.util.Map;

import com.ofvictor.acelera_java.aula05.business.ParametroLocacaoException;

public class Locadora {
    private static Map<String, Double> DIARIA_VEICULO = new HashMap<String, Double>();
    
    static {
    	Locadora.DIARIA_VEICULO.put("Passeio",40.0);
    	Locadora.DIARIA_VEICULO.put("SUV",100.0);
    	Locadora.DIARIA_VEICULO.put("Caminhonete",80.0);
    	Locadora.DIARIA_VEICULO.put("Moto",30.0);
    }
    
    public double locaVeiculo(int qtdDias, String tipoVeiculo) {
        if (qtdDias <= 0) {
            throw new ParametroLocacaoException("N�mero de dias da loca��o deve ser um n�mero positivo e maior que zero.");
        }
        
        if (tipoVeiculo == null) {
            throw new ParametroLocacaoException("O tipo de ve�culo deve ser informado.");
        }
        
        if (!Locadora.DIARIA_VEICULO.containsKey(tipoVeiculo)) {
            throw new ParametroLocacaoException("Favor informar um tipo de ve�culo v�lido.");
        }
        
        double custoLocacao = qtdDias * Locadora.DIARIA_VEICULO.get(tipoVeiculo);
        
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