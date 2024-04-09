/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.TableEstoque;

/**
 *
 * @author Senai
 */
public class EstoqueDAO {
    public List<TableEstoque> read() {
      List<TableEstoque> estoque = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM estoque");

            rs = stmt.executeQuery();

            while (rs.next()) {
                TableEstoque es = new TableEstoque();
                es.setId_estoque(rs.getInt("id_estoque"));
                es.setProduto_FK2(rs.getInt("produto_FK2"));
                es.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
                estoque.add(es);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estoque;
    }
    
    public boolean create(TableEstoque es) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO estoque (quantidade_estoque) VALUES (?)");
            stmt.setInt(1, es.getQuantidade_estoque());
          
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }      
    }
    
    public void update(TableEstoque es) {
        
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt;
            
            stmt = conexao.prepareStatement("UPDATE estoque SET quantidade_estoque = ? WHERE id_estoque = ?");
            stmt.setInt(1, es.getQuantidade_estoque());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(TableEstoque es){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt;
            
            stmt = conexao.prepareStatement("DELETE FROM estoque WHERE id_estoque = ?");
            stmt.setInt(1, es.getId_estoque());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
