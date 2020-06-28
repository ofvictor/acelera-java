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

import com.acelera.aula14.farmacia.model.Pedido;
import com.acelera.aula14.farmacia.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private PedidoService service;
    
    public PedidoController(PedidoService service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<Pedido>> getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }
    
    @GetMapping ("/{id}")
    public ResponseEntity<Optional<Pedido>> getById(@PathVariable("id") Long id) {
        Optional<Pedido> pedido = service.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(pedido);
    }
    
    @PostMapping
    public String create(@RequestBody Pedido pedido) {
        return this.service.create(pedido).toString();
    }
    
    @PutMapping
    public String update(@RequestBody Pedido pedido) {
        return this.service.update(pedido).toString();
    }
    
    @DeleteMapping ("/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.service.delete(id);
        return "Pedido " + id + " excluído.";
    }
}