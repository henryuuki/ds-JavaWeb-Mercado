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
import model.bean.TableCategoria;


/**
 *
 * @author Senai
 */
public class CategoriaDAO {
    public List<TableCategoria> read() {
      List<TableCategoria> categorias = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM categoria");

            rs = stmt.executeQuery();

            while (rs.next()) {
                TableCategoria c = new TableCategoria();
                c.setId_categoria(rs.getInt("id_categoria"));
                c.setNome(rs.getString("nome"));
                categorias.add(c);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categorias;
    }
    
    public List<TableCategoria> listarTodosC() {
        List<TableCategoria> categorias = new ArrayList();
        try {
            java.sql.Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM categoria");

            rs = stmt.executeQuery();

            while (rs.next()) {
                TableCategoria c = new TableCategoria();
                c.setId_categoria(rs.getInt("id_categoria"));
                c.setNome(rs.getString("nome"));
                categorias.add(c);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return categorias;
    }
    
    public boolean create(TableCategoria c) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO categoria (nome) VALUES (?)");
            stmt.setString(1, c.getNome());
          
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }      
    }
    
    public void update(TableCategoria c) {
        
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt;
            
            stmt = conexao.prepareStatement("UPDATE produto SET nome = ? WHERE id_produto = ?");
            stmt.setString(1, c.getNome());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(TableCategoria c){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt;
            
            stmt = conexao.prepareStatement("DELETE FROM categoria WHERE id_categoria = ?");
            stmt.setInt(1, c.getId_categoria());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
