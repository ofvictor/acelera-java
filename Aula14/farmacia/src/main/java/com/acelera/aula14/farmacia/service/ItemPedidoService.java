package com.acelera.aula14.farmacia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acelera.aula14.farmacia.model.ItemPedido;
import com.acelera.aula14.farmacia.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
    private ItemPedidoRepository repository;
    
    public ItemPedidoService(ItemPedidoRepository repository) {
        this.repository = repository;
    }
    
    public List<ItemPedido> getAll() { return this.repository.findAll(); }
    
    public ItemPedido getById(Long id) { return this.repository.getOne(id); }
    
    public ItemPedido create(ItemPedido itemPedido) { return this.repository.save(itemPedido); }
    
    public ItemPedido update(ItemPedido itemPedido) { return this.repository.save(itemPedido); }
    
    public void delete(Long id) { this.repository.deleteById(id); }
}