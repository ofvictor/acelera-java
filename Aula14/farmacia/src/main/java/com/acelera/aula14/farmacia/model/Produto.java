package com.acelera.aula14.farmacia.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id")
    private Long idProduto;

    @Column (name = "nome")
    private String nomeProduto;

    @OneToMany(mappedBy="produto")
    private List<OrdemCompra> ordensCompra;

    public Long getIdProduto() { return this.idProduto; }

    public String getNomeProduto() { return this.nomeProduto; }

    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }
}