package com.acelera.aula14.farmacia.service;

import com.acelera.aula14.farmacia.model.OrdemCompra;
import com.acelera.aula14.farmacia.repository.OrdemCompraRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemCompraService {
    private OrdemCompraRepository repository;

    public OrdemCompraService(OrdemCompraRepository repository) {
        this.repository = repository;
    }

    public List<OrdemCompra> getAll() {
        return this.repository.findAll();
    }

    public OrdemCompra getById(Long id) {
        return this.repository.getOne(id);
    }

    public OrdemCompra create(OrdemCompra ordemCompra) {
        return this.repository.save(ordemCompra);
    }

    public OrdemCompra update(OrdemCompra ordemCompra) {
        return this.repository.save(ordemCompra);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
