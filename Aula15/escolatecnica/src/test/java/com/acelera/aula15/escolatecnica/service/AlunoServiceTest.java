package com.acelera.aula15.escolatecnica.service;

import com.acelera.aula15.escolatecnica.domain.Aluno;
import com.acelera.aula15.escolatecnica.repository.AlunoRepository;

public class AlunoServiceTest {
    private AlunoRepository alunoRepository;

    @BeforeEach
    public void setUp() {
        this.alunoRepository = Mockito.mock(AlunoRepository.class);
    }

    @Test
    void salvaAlunoComSucesso() {
        // entradas / inputs
        Aluno esperado = new Aluno("Jonathan", "123456", "08/01/1988", "51-995938846");

        Mockito.when(alunoRepository.save(esperado)).thenReturn(esperado);
        // execução
        AlunoService alunoService = new AlunoService(alunoRepository);
        Aluno atual = alunoService.salvar(esperado);

        // verificação / validação
        assertEquals(esperado, atual);
        Mockito.verify(alunoRepository, Mockito.times(1)).save(esperado);
    }

    @Test()
    void falhaAoSalvarAlunoSemNome() {
        // entradas / inputs
        Aluno esperado = new Aluno(null, "123456", "08/01/1988", "51-995938846");

        // execução
        AlunoService alunoService = new AlunoService(alunoRepository);

        // verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            alunoService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(alunoRepository);
    }
}