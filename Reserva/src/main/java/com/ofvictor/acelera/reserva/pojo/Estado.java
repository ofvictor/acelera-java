package com.ofvictor.acelera.reserva.pojo;

public class Estado {
    private Integer idEstado;
    private String nomeEstado;
    private Integer idPais;
    private String nomePais;
    
    public Integer getIdEstado() {
        return idEstado;
    }
    
    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }
    
    public String getNomeEstado() {
        return nomeEstado;
    }
    
    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }
    
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
        return "[País: " + this.getIdPais() + " - " + this.getNomePais() + "] [Estado: " + this.getIdEstado() + "] " + this.getNomeEstado();
    }
}