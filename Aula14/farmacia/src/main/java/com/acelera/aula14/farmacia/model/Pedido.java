package com.acelera.aula14.farmacia.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id")
    private Long idPedido;

    @Column (name = "data")
    private String dataPedido;

    @Column (name = "origem")
    private String origemPedido;

    @OneToMany(mappedBy="pedido")
    private List<OrdemCompra> ordensCompra;

    public Long getIdPedido() { return this.idPedido; }

    public String getDataPedido() { return dataPedido; }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getOrigemPedido() {
        return origemPedido;
    }

    public void setOrigemPedido(String origemPedido) {
        this.origemPedido = origemPedido;
    }
}