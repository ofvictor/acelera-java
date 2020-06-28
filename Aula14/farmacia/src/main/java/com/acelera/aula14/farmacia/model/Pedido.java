package com.acelera.aula14.farmacia.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long idPedido;
    
    @Column (name = "data", nullable = false)
    private LocalDateTime dataPedido;
    
    @Column (name = "origem")
    private String origemPedido;
    
    @ManyToMany
    @JoinTable(name="item_pedido"
    	,joinColumns={@JoinColumn(name="id_pedido")}
    	,inverseJoinColumns={@JoinColumn(name="id_produto")}
    )
    private List<Produto> produtos;
    
    public Long getIdPedido() { return this.idPedido; }
    
    public void setDataPedido(LocalDateTime dataPedido) { this.dataPedido = dataPedido; }
    
    public LocalDateTime getDataPedido() { return this.dataPedido; }
    
    public void setOrigemPedido(String origemPedido) { this.origemPedido = origemPedido; }
    
    public String getOrigemPedido() { return this.origemPedido; }
    
	public List<Produto> getProdutos() { return produtos; }
	
	public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}