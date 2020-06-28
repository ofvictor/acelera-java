package com.acelera.aula14.farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.acelera.aula14.farmacia.model.Produto;
import com.acelera.aula14.farmacia.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private ProdutoRepository repository;
    
    public ProdutoService(ProdutoRepository repository) {
    	this.repository = repository;
    }
    
    public List<Produto> getAll() { return this.repository.findAll(); }
    
    public Optional<Produto> getById(Long id) { return repository.findById(id); }
    
    public Produto create(Produto produto) { return this.repository.save(produto); }
    
    public Produto update(Produto produto) { return this.repository.save(produto); }
    
    public void delete(Long id) { this.repository.deleteById(id); }
}