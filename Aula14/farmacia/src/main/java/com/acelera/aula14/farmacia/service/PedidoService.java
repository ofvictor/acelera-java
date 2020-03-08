package com.acelera.aula14.farmacia.service;

import com.acelera.aula14.farmacia.model.Pedido;
import com.acelera.aula14.farmacia.repository.PedidoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public List<Pedido> getAll() { return this.repository.findAll(); }

    public Pedido getById(Long id) {
        return this.repository.getOne(id);
    }

    public Pedido create(Pedido pedido) { return this.repository.save(pedido); }

    public Pedido update(Pedido pedido) {
        return this.repository.save(pedido);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}