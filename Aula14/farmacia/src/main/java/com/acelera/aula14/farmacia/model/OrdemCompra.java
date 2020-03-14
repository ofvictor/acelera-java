package com.acelera.aula14.farmacia.model;

import javax.persistence.*;

@Entity
@Table(name = "ordem_compra")
public class OrdemCompra {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id", updatable = false, nullable = false)
    private Long idOrdemCompra;
    
    @Column(name = "quantidade")
    private Long quantidade;
    
    public Long getIdOrdemCompra() { return this.idOrdemCompra; }
    
    public void setQuantidade(Long quantidade) { this.quantidade = quantidade; }
    
    public Long getQuantidade() { return this.quantidade; }
}