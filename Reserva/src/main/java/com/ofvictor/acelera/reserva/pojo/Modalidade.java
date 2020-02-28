package com.ofvictor.acelera.reserva.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="modalidade")
public class Modalidade {
    
	@Id
    @GeneratedValue(generator = "sequence_modalidade", strategy = GenerationType.AUTO)
    @Column (name = "id_modalidade") // opcional, o Hybernate assume por default a convers�o de camelCase para '_'
	private Long idModalidade;
    private String nome;
    
    public Long getIdModalidade() {
        return idModalidade;
    }
    
    public void setIdModalidade(Long idModalidade) {
        this.idModalidade = idModalidade;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "[Modalidade: " + this.getIdModalidade() + "] " + this.getNome();
    }
}