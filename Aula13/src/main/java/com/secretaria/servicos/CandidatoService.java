package com.secretaria.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.secretaria.dominios.Candidato;
import com.secretaria.repositorios.CandidatoRepository;

@Service
public class CandidatoService {
    private CandidatoRepository candidatoRepository;
    
	public CandidatoService(CandidatoRepository candidatoRepository) {
    	this.candidatoRepository = candidatoRepository;
    }
	
	public List<Candidato> listarCandidatos() {
		return this.candidatoRepository.getCandidatos();
	}
	
	public Candidato findByName(String nome) {
		return this.candidatoRepository.findByName(nome);
	}
	
	public boolean delete(Candidato candidato) {
		return this.candidatoRepository.delete(candidato);
	}
}