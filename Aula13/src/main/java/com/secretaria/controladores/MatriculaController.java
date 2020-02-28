package com.secretaria.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secretaria.dominios.Candidato;
import com.secretaria.servicos.MatriculaService;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {
    private MatriculaService matriculaService;
    
    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }
    
    @PostMapping
    public ResponseEntity receberMatricula(@RequestBody Candidato candidato) {
        matriculaService.cadastrarCandidato(candidato);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}