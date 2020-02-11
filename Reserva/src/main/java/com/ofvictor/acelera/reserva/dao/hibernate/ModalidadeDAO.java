package com.ofvictor.acelera.reserva.dao.hibernate;

import java.util.List;

import javax.management.Query;
import javax.persistence.*;

import com.ofvictor.acelera.reserva.dao.DAO;
import com.ofvictor.acelera.reserva.pojo.Modalidade;

public class ModalidadeDAO implements DAO<Modalidade> {
	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager = null;
	
	public void begin() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("reserva-pu");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	public void close() {
		if (this.entityManager != null) this.entityManager.close();
		if (this.entityManagerFactory != null) this.entityManagerFactory.close();
	}
	
	@Override
	public void salvar(Modalidade modalidade) {
		this.begin();
		this.entityManager.persist(modalidade);
		this.close();
	}
	
	@Override
	public void atualizar(Modalidade modalidade) {
		this.begin();
		this.entityManager.persist(modalidade);
		this.close();
	}
	
	@Override
	public void deletar(Modalidade modalidade) {
		this.begin();
		this.entityManager.remove(modalidade);
		this.close();
	}
	
	@Override
	public List<Modalidade> listarTodos() {
		this.begin();
		Query modalidade = (Query) this.entityManager.createQuery("SELECT * FROM modalidade");
		List<Modalidade> modalidades = ((javax.persistence.Query) modalidade).getResultList();
		this.close();
		return modalidades;
	}
}