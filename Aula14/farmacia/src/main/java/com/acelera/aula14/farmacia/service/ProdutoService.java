package com.acelera.aula14.farmacia.service;

import com.acelera.aula14.farmacia.model.Produto;
import com.acelera.aula14.farmacia.repository.ProdutoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> getAll() {
        return this.repository.findAll();
    }

    public Produto getById(Long id) {
        return this.repository.getOne(id);
    }

    public Produto create(Produto produto) {
        return this.repository.save(produto);
    }

    public Produto update(Produto produto) {
        return this.repository.save(produto);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}