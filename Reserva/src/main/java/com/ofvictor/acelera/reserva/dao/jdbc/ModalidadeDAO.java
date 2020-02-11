package com.ofvictor.acelera.reserva.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ofvictor.acelera.reserva.connection.JDBCConnection;
import com.ofvictor.acelera.reserva.dao.DAO;
import com.ofvictor.acelera.reserva.pojo.Modalidade;

public class ModalidadeDAO implements DAO<Modalidade> {
    @Override
    public void salvar(Modalidade domain) {
        Connection conexao = JDBCConnection.getConnection();
        String sql = "INSERT INTO modalidade(nome) VALUES (?)";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, domain.getNome());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void atualizar(Modalidade domain) {
        Connection conexao = JDBCConnection.getConnection();
        String sql = "UPDATE modalidade SET nome = ? WHERE id_modalidade = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, domain.getNome());
            ps.setInt(2, domain.getIdModalidade());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void deletar(Modalidade domain) {
        Connection conexao = JDBCConnection.getConnection();
        String sql = "DELETE FROM modalidade WHERE id_modalidade = ?";
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, domain.getIdModalidade());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Modalidade> listarTodos() {
        Connection conexao = JDBCConnection.getConnection();
        String sql = "SELECT id_modalidade, nome FROM modalidade";
        List<Modalidade> listaModalidades = new ArrayList<>();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Modalidade modalidade = new Modalidade();
                modalidade.setIdModalidade(rs.getInt("id_modalidade"));
                modalidade.setNome(rs.getString("nome"));
                listaModalidades.add(modalidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaModalidades;
    }
}