package com.ofvictor.acelera.reserva.pojo;

public class TipoPasseio {
    private Integer idTipoPasseio;
    private String nomePasseio;
    private String descricaoPasseio;

    public Integer getIdTipoPasseio() {
        return idTipoPasseio;
    }

    public void setIdTipoPasseio(Integer idTipoPasseio) {
        this.idTipoPasseio = idTipoPasseio;
    }

    public String getNomePasseio() {
        return this.nomePasseio;
    }

    public void setNomePasseio(String nomePasseio) {
        this.nomePasseio = nomePasseio;
    }
    
    public String getDescricaoPasseio() {
		return this.descricaoPasseio;
	}
    
	public void setDescricaoPasseio(String descricaoPasseio) {
		this.descricaoPasseio = descricaoPasseio;
	}
	
	@Override
    public String toString() {
        return "[Tipo de Passeio: " + this.getIdTipoPasseio() + "] " + this.getNomePasseio();
    }
}