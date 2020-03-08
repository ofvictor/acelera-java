package com.acelera.aula14.farmacia.controller;

import com.acelera.aula14.farmacia.model.Produto;
import com.acelera.aula14.farmacia.service.ProdutoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Produto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.service.getById(id));
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