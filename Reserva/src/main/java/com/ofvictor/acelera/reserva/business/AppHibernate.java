package com.ofvictor.acelera.reserva.business;

import com.ofvictor.acelera.reserva.dao.hibernate.ModalidadeDAO;
//import com.ofvictor.acelera.reserva.dao.jdbc.EstadoDAO;
//import com.ofvictor.acelera.reserva.dao.jdbc.PaisDAO;
//import com.ofvictor.acelera.reserva.dao.jdbc.TipoPasseioDAO;
import com.ofvictor.acelera.reserva.pojo.Modalidade;

public class AppHibernate {
	public void insereEListaModalidades() {
        ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
        Modalidade modalidade = new Modalidade();
        modalidade.setNome("Bike Trekking");
        modalidadeDAO.salvar(modalidade);
        modalidadeDAO.listarTodos().forEach(System.out::println);
	}
	
/*	public void insereEListaTiposPasseio() {
		TipoPasseioDAO tipoPasseioDAO = new TipoPasseioDAO();
		TipoPasseio tipoPasseio = new TipoPasseio();
		tipoPasseio.setNomePasseio("Grupo Infantil");
		tipoPasseio.setDescricaoPasseio("Grupos infantis até 8 anos de idade");
		tipoPasseioDAO.salvar(tipoPasseio);
		tipoPasseioDAO.listarTodos().forEach(System.out::println);
	}*/
	
/*	public void insereEListaPaises() {
		PaisDAO paisDAO = new PaisDAO();
		Pais pais = new Pais();
		pais.setNomePais("Bolívia");
		paisDAO.salvar(pais);
		paisDAO.listarTodos().forEach(System.out::println);
	}*/
	
/*	public void insereEListaEstados() {
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = new Estado();
		estado.setNomeEstado("Santiago");
		estado.setNomePais("Chile");
		estadoDAO.salvar(estado);
		estadoDAO.listarTodos().forEach(System.out::println);
	}*/
	
    public static void main(String[] args) {
    	AppHibernate app = new AppHibernate();
    	
    	app.insereEListaModalidades();
//    	app.insereEListaTiposPasseio();
//    	app.insereEListaPaises();
//    	app.insereEListaEstados();
    }
}