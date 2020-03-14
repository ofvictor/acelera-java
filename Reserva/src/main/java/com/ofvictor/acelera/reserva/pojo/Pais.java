package com.ofvictor.acelera.reserva.pojo;

public class Pais {
    private Integer idPais;
    private String nomePais;

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }
    
    @Override
    public String toString() {
        return "[País: " + this.getIdPais() + "] " + this.getNomePais();
    }
}