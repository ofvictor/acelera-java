package com.ofvictor.acelera.reserva.dao;

import java.util.List;

public interface DAO<T> {
    void salvar(T domain);
    
    void atualizar(T domain);
    
    void deletar(T domain);
    
    List<T> listarTodos();
}