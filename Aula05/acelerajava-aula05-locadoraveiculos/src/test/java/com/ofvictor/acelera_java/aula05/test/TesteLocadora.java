package com.ofvictor.acelera_java.aula05.test;

import com.ofvictor.acelera_java.aula05.business.*;
import com.ofvictor.acelera_java.aula05.exception.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TesteLocadora {
    private static Locadora LOCADORA = new Locadora();
    private static final double VARIACAO = 0.000001;
    
    @Test(expected = ParametroLocacaoException.class)
    public void testaQuantidadesDias(){
        LOCADORA.locaVeiculo(0,"SUV");
    }
    
    @Test(expected = ParametroLocacaoException.class)
    public void testaTipoVeiculoNull(){
        LOCADORA.locaVeiculo(1,null);
    }
    
    @Test(expected = ParametroLocacaoException.class)
    public void testaTipoVeiculoInexistente(){
        LOCADORA.locaVeiculo(1,"Jamanta");
    }
    
    @Test
    public void testaVeiculoPasseioPeriodoCurto() {
        assertEquals(LOCADORA.locaVeiculo(3,"Passeio"),126.0,VARIACAO);
    }
    
    @Test
    public void testaVeiculoPasseioPeriodoMedio(){
        assertEquals(LOCADORA.locaVeiculo(6,"Passeio"),264.0,VARIACAO);
    }
    
    @Test
    public void testaVeiculoPasseioPeriodoLongo(){
        assertEquals(LOCADORA.locaVeiculo(11,"Passeio"),528.0,VARIACAO);
    }
    
    @Test
    public void testaVeiculoSUVPeriodoCurto(){
        assertEquals(LOCADORA.locaVeiculo(3,"SUV"),315.0,VARIACAO);
    }
    
    @Test
    public void testaVeiculoSUVPeriodoMedio(){
        assertEquals(LOCADORA.locaVeiculo(6,"SUV"),660.0,VARIACAO);
    }
    
    @Test
    public void testaVeiculoSUVPeriodoLongo(){
        assertEquals(LOCADORA.locaVeiculo(11,"SUV"),1320.0,VARIACAO);
    }
    
    @Test
    public void testaVeiculoCaminhonetePeriodoCurto(){
        assertEquals(LOCADORA.locaVeiculo(3,"Caminhonete"),252.0,VARIACAO);
    }
    
    @Test
    public void testaVeiculoCaminhonetePeriodoMedio(){
        assertEquals(LOCADORA.locaVeiculo(6,"Caminhonete"),528.0,VARIACAO);
    }
    
    @Test
    public void testaVeiculoCaminhonetePeriodoLongo(){
        assertEquals(LOCADORA.locaVeiculo(11,"Caminhonete"),1056.0,VARIACAO);
    }
    
    @Test
    public void testaVeiculoMotoPeriodoCurto(){
        assertEquals(LOCADORA.locaVeiculo(3,"Moto"),94.5,VARIACAO);
    }
    
    @Test
    public void testaVeiculoMotoPeriodoMedio(){
        assertEquals(LOCADORA.locaVeiculo(6,"Moto"),198.0,VARIACAO);
    }
    
    @Test
    public void testaVeiculoMotoPeriodoLongo(){
        assertEquals(LOCADORA.locaVeiculo(11,"Moto"),396.0,VARIACAO);
    }
}