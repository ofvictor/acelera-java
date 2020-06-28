package com.acelera.aula14.farmacia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acelera.aula14.farmacia.model.Produto;
import com.acelera.aula14.farmacia.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private ProdutoService service;
    
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }
    
    @GetMapping ("/{id}")
    public ResponseEntity<Optional<Produto>> getById(@PathVariable("id") Long id) {
        Optional<Produto> produto = service.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }
    
    @PostMapping
    public String create(@RequestBody Produto produto) {
        return this.service.create(produto).toString();
    }
    
    @PutMapping
    public String update(@RequestBody Produto produto) {
        return this.service.update(produto).toString();
    }
    
    @DeleteMapping ("/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.service.delete(id);
        return "Produto " + id + " excluído.";
    }
}