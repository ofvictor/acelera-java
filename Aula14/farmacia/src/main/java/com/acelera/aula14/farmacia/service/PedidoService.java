package com.acelera.aula14.farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.acelera.aula14.farmacia.model.Pedido;
import com.acelera.aula14.farmacia.repository.PedidoRepository;

@Service
public class PedidoService {
    private PedidoRepository repository;
    
    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }
    
    public List<Pedido> getAll() { return this.repository.findAll(); }
    
    public Optional<Pedido> getById(Long id) { return repository.findById(id); }
    
    public Pedido create(Pedido pedido) { return this.repository.save(pedido); }
    
    public Pedido update(Pedido pedido) { return this.repository.save(pedido); }
    
    public void delete(Long id) { this.repository.deleteById(id); }
}