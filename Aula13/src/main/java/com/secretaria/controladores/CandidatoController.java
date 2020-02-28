package com.secretaria.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secretaria.dominios.Candidato;
import com.secretaria.exceptions.SecretariaException;
import com.secretaria.servicos.CandidatoService;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {
    private CandidatoService candidatoService;
    
    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }
    
    @GetMapping
    public ResponseEntity listarMatriculas() {
        return ResponseEntity.ok(this.candidatoService.listarCandidatos());
    }
    
    @DeleteMapping("/{nome}")
    public ResponseEntity excluirCandidato(@PathVariable("nome") String nome) {
    	ResponseEntity responseEntity = null;
    	
    	try {
    		Candidato candidato = this.candidatoService.findByName(nome);
    		if (candidato == null) {
        		System.out.println("Candidato NÃO encontrado!");
    		} else {
        		System.out.println("Candidato encontrado: " + candidato.toString());
    		}
    		
    		this.candidatoService.delete(candidato);
       		responseEntity = ResponseEntity.ok().build();
    	} catch (SecretariaException exception) {
    		responseEntity = ResponseEntity.notFound().build();
    	}
    	
    	return responseEntity;
    }
}