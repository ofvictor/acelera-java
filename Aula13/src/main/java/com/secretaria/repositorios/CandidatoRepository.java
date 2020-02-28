package com.secretaria.repositorios;

import com.secretaria.dominios.Candidato;
import com.secretaria.exceptions.SecretariaException;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CandidatoRepository {
    private List<Candidato> candidatos = new ArrayList<Candidato>();
    
    public Candidato save(Candidato candidato) {
        candidatos.add(candidato);
        return candidato;
    }
    
	public List<Candidato> getCandidatos() {
		return this.candidatos;
	}
	
	public Candidato findByName(String nome) {
		Candidato candidatoEncontrado = null;
		
		System.out.println("Nome recebido para busca: " + nome + ".");
		System.out.println("Tamanho da lista: " + this.candidatos.size() + ".");
		int contador = 0;
		
		for (Candidato candidato : this.candidatos) {
			System.out.println("[" + (++contador) + "] Candidato " + candidato.getNome() + ".");
			
			if (candidato.getNome().equals(nome)) {
				candidatoEncontrado = candidato;
				break;
			}
		}
		
		if (candidatoEncontrado == null) throw new SecretariaException("Não foi encontrado candidato com o nome " + nome + ".");
		
		return candidatoEncontrado;
	}
	
	public boolean delete(Candidato candidato) {
		return this.candidatos.remove(candidato);
	}
}