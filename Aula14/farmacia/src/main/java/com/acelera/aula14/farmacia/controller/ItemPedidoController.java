package com.acelera.aula14.farmacia.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acelera.aula14.farmacia.model.ItemPedido;
import com.acelera.aula14.farmacia.service.ItemPedidoService;

@RestController
@RequestMapping("/item-pedido")
public class ItemPedidoController {
	private ItemPedidoService service;
	
	public ItemPedidoController(ItemPedidoService service) {
            this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<ItemPedido>> getAll() {
		return ResponseEntity.ok(this.service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemPedido> getById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.getById(id));
	}
	
	@PostMapping
	public String create(@RequestBody ItemPedido itemPedido) {
		return this.service.create(itemPedido).toString();
	}
	
	@PutMapping
	public String update(@RequestBody ItemPedido itemPedido) {
		return this.service.update(itemPedido).toString();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.service.delete(id);
		return "Item de Pedido " + id + " excluído.";
	}
}