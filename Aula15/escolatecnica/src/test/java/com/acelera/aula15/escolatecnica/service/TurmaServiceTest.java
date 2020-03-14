package com.acelera.aula15.escolatecnica.service;

import com.acelera.aula15.escolatecnica.domain.Aluno;
import com.acelera.aula15.escolatecnica.domain.Curso;
import com.acelera.aula15.escolatecnica.domain.Matricula;
import com.acelera.aula15.escolatecnica.domain.Turma;
import com.acelera.aula15.escolatecnica.dto.TurmaDTO;
import com.acelera.aula15.escolatecnica.repository.TurmaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TurmaServiceTest {
    @Mock
    private TurmaRepository turmaRepository;

    @Mock
    private CursoService cursoService;

    @Mock
    private MatriculaService matriculaService;

    @InjectMocks
    private TurmaService turmaService;

    @BeforeEach
    public void setUp() {
        this.turmaRepository = Mockito.mock(TurmaRepository.class);
    }

    @Test
    void salvaTurmaComSucesso() {
        // entrada
        TurmaDTO turmaDTO = new TurmaDTO("14/03/2020", "27/05/2020", 1L, Arrays.asList(1L, 2L, 3L, 4L));

        Curso curso = new Curso();
        List<Aluno> alunos = Arrays.asList(new Aluno());
        List<Matricula> matriculas = Arrays.asList(new Matricula());
        Turma turma = new Turma(turmaDTO.getDataInicio(),turmaDTO.getDataFinal(), curso);

        when(cursoService.findById(turmaDTO.getIdCurso())).thenReturn(curso);
        when(turmaRepository.save(turma)).thenReturn(turma);

        // execução
        Turma atual = turmaService.save(turmaDTO);

        // verificação
        assertEquals(turma, atual);
        verify(cursoService, times(1)).findById(turmaDTO.getIdCurso());
        verify(turmaRepository).save(turma);
        verify(matriculaService).save(turma, turmaDTO.getIdAlunos());
    }

    @Test
    void falhaAoSalvarTurmaSemCurso() {
        // entradas / inputs
        Turma esperado = new Turma(null, "01-03-2020", "30-03-2020");

        when(turmaRepository.save(esperado)).thenReturn(esperado);
        // execução
        TurmaService turmaService = new TurmaService(turmaRepository);
        Turma atual = turmaService.save(esperado);

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

        when(turmaRepository.save(esperado)).thenReturn(esperado);
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

        when(turmaRepository.save(esperado)).thenReturn(esperado);
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
