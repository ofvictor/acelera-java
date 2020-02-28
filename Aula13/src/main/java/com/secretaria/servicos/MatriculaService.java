package com.secretaria.servicos;

import com.secretaria.dominios.Candidato;
import com.secretaria.dominios.PreMatricula;
import com.secretaria.repositorios.CandidatoRepository;
import com.secretaria.repositorios.PreMatriculaRepository;

import org.springframework.stereotype.Service;

@Service
public class MatriculaService {
	private CandidatoRepository candidatoRepository;
	private PreMatriculaRepository preMatriculaRepository;
    
    public MatriculaService(CandidatoRepository candidatoRepository,
                            PreMatriculaRepository preMatriculaRepository) {
        this.candidatoRepository = candidatoRepository;
        this.preMatriculaRepository = preMatriculaRepository;
    }
    
    public void cadastrarCandidato(Candidato candidato) {
        Candidato candidatoSalvo = candidatoRepository.save(candidato);
        PreMatricula preMatricula = new PreMatricula(Boolean.FALSE, candidatoSalvo);
        preMatriculaRepository.save(preMatricula);
    }
}