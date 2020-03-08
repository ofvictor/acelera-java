package com.acelera.aula14.farmacia.controller;

import com.acelera.aula14.farmacia.model.OrdemCompra;
import com.acelera.aula14.farmacia.service.OrdemCompraService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @RestController
    @RequestMapping("/ordem-compra")
    public class OrdemCompraController {
        private OrdemCompraService service;

        public OrdemCompraController(OrdemCompraService service) {
            this.service = service;
        }

        @GetMapping
        public ResponseEntity<List<OrdemCompra>> getAll() {
            return ResponseEntity.ok(this.service.getAll());
        }

        @GetMapping ("/{id}")
        public ResponseEntity<OrdemCompra> getById(@PathVariable("id") Long id) {
            return ResponseEntity.ok(this.service.getById(id));
        }

        @PostMapping
        public String create(@RequestBody OrdemCompra ordemCompra) {
            return this.service.create(ordemCompra).toString();
        }

        @PutMapping
        public String update(@RequestBody OrdemCompra ordemCompra) {
            return this.service.update(ordemCompra).toString();
        }

        @DeleteMapping ("/{id}")
        public String delete(@PathVariable("id") Long id) {
            this.service.delete(id);
            return "Ordem de compra " + id + " excluída.";
        }
}
