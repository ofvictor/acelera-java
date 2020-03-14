package com.acelera.aula14.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acelera.aula14.farmacia.model.OrdemCompra;

@Repository
public interface OrdemCompraRepository extends JpaRepository<OrdemCompra, Long> {
}
