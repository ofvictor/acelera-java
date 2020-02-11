package com.ofvictor.acelera.reserva.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ofvictor.acelera.reserva.connection.JDBCConnection;
import com.ofvictor.acelera.reserva.dao.DAO;
import com.ofvictor.acelera.reserva.pojo.Estado;

public class EstadoDAO implements DAO<Estado> {
    @Override
    public void salvar(Estado domain) {
        Connection conexao = JDBCConnection.getConnection();
        String sql = "INSERT INTO estado(nome_estado,id_pais) VALUES (?,(SELECT id_pais FROM pais WHERE nome_pais = ?))";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, domain.getNomeEstado());
            ps.setString(2, domain.getNomePais());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void atualizar(Estado domain) {
        Connection conexao = JDBCConnection.getConnection();
        String sql = "UPDATE estado SET nome_estado = ? WHERE id_estado = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, domain.getNomeEstado());
            ps.setInt(2, domain.getIdEstado());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void deletar(Estado domain) {
        Connection conexao = JDBCConnection.getConnection();
        String sql = "DELETE FROM estado WHERE id_estado = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, domain.getIdEstado());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Estado> listarTodos() {
        Connection conexao = JDBCConnection.getConnection();
        String sql = "SELECT pai.id_pais, pai.nome_pais, est.id_estado, est.nome_estado FROM pais pai, estado est WHERE est.id_pais = pai.id_pais";
        List<Estado> listaEstados = new ArrayList<>();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
            	Estado estado = new Estado();
            	estado.setIdPais(rs.getInt("pai.id_pais"));
            	estado.setNomePais(rs.getString("pai.nome_pais"));
            	estado.setIdEstado(rs.getInt("est.id_estado"));
            	estado.setNomeEstado(rs.getString("est.nome_estado"));
            	
            	listaEstados.add(estado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaEstados;
    }
}