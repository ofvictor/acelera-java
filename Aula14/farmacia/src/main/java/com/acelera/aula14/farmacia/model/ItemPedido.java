package com.acelera.aula14.farmacia.model;

import javax.persistence.*;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id", updatable = false, nullable = false)
    private Long idItemPedido;
    
    @Column(name = "quantidade")
    private Long quantidade;
    
    public Long getIdOrdemCompra() { return this.idItemPedido; }
    
    public void setQuantidade(Long quantidade) { this.quantidade = quantidade; }
    
    public Long getQuantidade() { return this.quantidade; }
}