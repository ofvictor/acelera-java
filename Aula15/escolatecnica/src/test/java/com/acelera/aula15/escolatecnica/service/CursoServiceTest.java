package com.acelera.aula15.escolatecnica.service;

import com.acelera.aula15.escolatecnica.domain.Curso;
import com.acelera.aula15.escolatecnica.domain.ModalidadeEnum;
import com.acelera.aula15.escolatecnica.repository.CursoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CursoServiceTest {
    private CursoRepository cursoRepository;

    @BeforeEach
    public void setUp() {
        this.cursoRepository = Mockito.mock(CursoRepository.class);
    }

    @Test
    void salvaCursoComSucesso() {
        // entradas / inputs
        Curso esperado = new Curso("Java 8", "Novidades da linguagem na versão 8", "Lógica de programação e Java anterior", ModalidadeEnum.TECHNICAL);

        Mockito.when(cursoRepository.save(esperado)).thenReturn(esperado);
        // execução
        CursoService cursoService = new CursoService(cursoRepository);
        Curso atual = cursoService.salvar(esperado);

        // verificação / validação
        assertEquals(esperado, atual);
        Mockito.verify(cursoRepository, Mockito.times(1)).save(esperado);
    }

    @Test()
    void falhaAoSalvarCursoSemNome() {
        // entradas / inputs
        Curso esperado = new Curso(null, "Novidades da linguagem na versão 8", "Lógica de programação e Java anterior", ModalidadeEnum.TECHNICAL);

        // execução
        CursoService cursoService = new CursoService(cursoRepository);

        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            cursoService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(cursoRepository);
    }

    @Test()
    void falhaAoSalvarCursoSemDescricao() {
        // entradas / inputs
        Curso esperado = new Curso("Java 8", null, "Lógica de programação e Java anterior", ModalidadeEnum.TECHNICAL);

        // execução
        CursoService cursoService = new CursoService(cursoRepository);

        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            cursoService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(cursoRepository);
    }

    @Test()
    void falhaAoSalvarCursoSemRequisitos() {
        // entradas / inputs
        Curso esperado = new Curso("Java 8", "Novidades da linguagem na versão 8", null, ModalidadeEnum.TECHNICAL);

        // execução
        CursoService cursoService = new CursoService(cursoRepository);

        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            cursoService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(cursoRepository);
    }

    @Test() void falhaAoSalvarCursoSemModalidade() {
        // entradas / inputs
        Curso esperado = new Curso("Java 8", "Novidades da linguagem na versão 8", "Lógica de programação e Java anterior", null);

        // execução
        CursoService cursoService = new CursoService(cursoRepository);

        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            cursoService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(cursoRepository);
    }
}