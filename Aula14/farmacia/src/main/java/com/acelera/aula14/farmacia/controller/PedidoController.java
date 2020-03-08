package com.acelera.aula14.farmacia.controller;

import com.acelera.aula14.farmacia.model.Pedido;
import com.acelera.aula14.farmacia.service.PedidoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Pedido> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.service.getById(id));
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