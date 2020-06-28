package com.acelera.aula14.farmacia.model;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long idProduto;
    
    @Column (name = "nome")
    private String nomeProduto;
    
    public Long getIdProduto() { return this.idProduto; }
    
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }
    
    public String getNomeProduto() { return this.nomeProduto; }
}