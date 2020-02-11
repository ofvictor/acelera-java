package com.ofvictor.acelera.reserva.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ofvictor.acelera.reserva.connection.JDBCConnection;
import com.ofvictor.acelera.reserva.dao.DAO;
import com.ofvictor.acelera.reserva.pojo.Pais;

public class PaisDAO implements DAO<Pais> {
    @Override
    public void salvar(Pais domain) {
        Connection conexao = JDBCConnection.getConnection();
        String sql = "INSERT INTO pais (nome_pais) VALUES (?)";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, domain.getNomePais());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void atualizar(Pais domain) {
        Connection conexao = JDBCConnection.getConnection();
        String sql = "UPDATE pais SET nome_pais = ? WHERE id_pais = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, domain.getNomePais());
            ps.setInt(2, domain.getIdPais());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void deletar(Pais domain) {
        Connection conexao = JDBCConnection.getConnection();
        String sql = "DELETE FROM pais WHERE id_pais = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, domain.getIdPais());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Pais> listarTodos() {
        Connection conexao = JDBCConnection.getConnection();
        String sql = "SELECT id_pais, nome_pais FROM pais";
        List<Pais> listaPaises = new ArrayList<>();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pais modalidade = new Pais();
                modalidade.setIdPais(rs.getInt("id_pais"));
                modalidade.setNomePais(rs.getString("nome_pais"));
                listaPaises.add(modalidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaPaises;
    }
}