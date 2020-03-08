package com.acelera.aula14.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acelera.aula14.farmacia.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}