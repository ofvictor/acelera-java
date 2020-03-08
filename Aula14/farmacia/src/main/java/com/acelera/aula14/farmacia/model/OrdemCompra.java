package com.acelera.aula14.farmacia.model;

import javax.persistence.*;

@Entity
@Table(name = "ordem_compra")
public class OrdemCompra {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id")
    private Long idOrdemCompra;

    @Column(name = "quantidade")
    private Long quantidade;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public Long getIdOrdemCompra() { return this.idOrdemCompra; }

    public Pedido getPedido() { return this.pedido; }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getQuantidade() { return this.quantidade; }

    public void setQuantidade(Long quantidade) { this.quantidade = quantidade; }
}