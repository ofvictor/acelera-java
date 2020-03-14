package com.acelera.aula15.escolatecnica.service;

import com.acelera.aula15.escolatecnica.domain.Aluno;
import com.acelera.aula15.escolatecnica.domain.Matricula;
import com.acelera.aula15.escolatecnica.repository.MatriculaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatriculaServiceTest {
    private MatriculaRepository matriculaRepository;

    @BeforeEach
    public void setUp() {
        this.matriculaRepository = Mockito.mock(MatriculaRepository.class);
    }

    @Test
    void salvaMatriculaComSucesso() {
        // entradas / inputs
        Matricula esperado = new Matricula();

        Mockito.when(matriculaRepository.save(esperado)).thenReturn(esperado);
        // execução
        MatriculaService matriculaService = new AlunoService(this.matriculaRepository);
        Aluno atual = matriculaService.salvar(esperado);

        // verificação / validação
        assertEquals(esperado, atual);
        Mockito.verify(matriculaRepository, Mockito.times(1)).save(esperado);
    }
}
