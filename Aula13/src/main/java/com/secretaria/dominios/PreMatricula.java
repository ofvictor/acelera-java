package com.secretaria.dominios;

public class PreMatricula {
    private Boolean avaliado;
    private Candidato candidato;
    
    public PreMatricula(Boolean avaliado, Candidato candidato) {
        this.avaliado = avaliado;
        this.candidato = candidato;
    }
    
    public Boolean getAvaliado() {
        return avaliado;
    }
    
    public void setAvaliado(Boolean avaliado) {
        this.avaliado = avaliado;
    }
    
    public Candidato getCandidato() {
        return candidato;
    }
    
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    @Override
    public String toString() {
        return "PreMatricula{" +
                "avaliado=" + avaliado +
                ", candidato=" + candidato +
                '}';
    }
}