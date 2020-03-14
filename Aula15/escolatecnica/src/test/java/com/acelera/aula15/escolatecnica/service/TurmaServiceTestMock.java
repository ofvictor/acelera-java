package com.acelera.aula15.escolatecnica.service;

import com.acelera.aula15.escolatecnica.domain.Turma;
import com.acelera.aula15.escolatecnica.repository.TurmaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurmaServiceTest {
    private TurmaRepository turmaRepository;

    @BeforeEach
    public void setUp() {
        this.turmaRepository = Mockito.mock(TurmaRepository.class);
    }

    @Test
    void salvaTurmaComSucesso() {
        // entradas / inputs
        Turma esperado = new Turma(1L, "01-03-2020", "30-03-2020");

        Mockito.when(turmaRepository.save(esperado)).thenReturn(esperado);
        // execução
        TurmaService turmaService = new TurmaService(turmaRepository);
        Turma atual = turmaService.salvar(esperado);

        // verificação / validação
        assertEquals(esperado, atual);
        Mockito.verify(turmaRepository, Mockito.times(1)).save(esperado);
    }

    @Test
    void falhaAoSalvarTurmaSemCurso() {
        // entradas / inputs
        Turma esperado = new Turma(null, "01-03-2020", "30-03-2020");

        Mockito.when(turmaRepository.save(esperado)).thenReturn(esperado);
        // execução
        TurmaService turmaService = new TurmaService(turmaRepository);
        Turma atual = turmaService.salvar(esperado);

        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            turmaService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(turmaRepository);
    }

    @Test
    void falhaAoSalvarTurmaSemDataInicio() {
        // entradas / inputs
        Turma esperado = new Turma(1L, null, "30-03-2020");

        Mockito.when(turmaRepository.save(esperado)).thenReturn(esperado);
        // execução
        TurmaService turmaService = new TurmaService(turmaRepository);
        Turma atual = turmaService.salvar(esperado);

        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            turmaService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(turmaRepository);
    }

    @Test
    void falhaAoSalvarTurmaSemDataFim() {
        // entradas / inputs
        Turma esperado = new Turma(1L, "01-03-2020", null);

        Mockito.when(turmaRepository.save(esperado)).thenReturn(esperado);
        // execução
        TurmaService turmaService = new TurmaService(turmaRepository);
        Turma atual = turmaService.salvar(esperado);

        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            turmaService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(turmaRepository);
    }
}
