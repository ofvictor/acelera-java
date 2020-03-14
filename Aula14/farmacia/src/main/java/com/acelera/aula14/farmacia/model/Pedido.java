package com.acelera.aula14.farmacia.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id", updatable = false, nullable = false)
    private Long idPedido;
    
    @Column (name = "data")
    private String dataPedido;
    
    @Column (name = "origem")
    private String origemPedido;
    
    @ManyToMany
    @JoinTable(name="ordem_compra"
    	,joinColumns={@JoinColumn(name="id_pedido")}
    	,inverseJoinColumns={@JoinColumn(name="id_produto")}
    )
    private List<Produto> produtos;
    
    public Long getIdPedido() { return this.idPedido; }
    
    public void setDataPedido(String dataPedido) { this.dataPedido = dataPedido; }
    
    public String getDataPedido() { return this.dataPedido; }
    
    public void setOrigemPedido(String origemPedido) { this.origemPedido = origemPedido; }
    
    public String getOrigemPedido() { return this.origemPedido; }
    
	public List<Produto> getProdutos() { return produtos; }
	
	public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}