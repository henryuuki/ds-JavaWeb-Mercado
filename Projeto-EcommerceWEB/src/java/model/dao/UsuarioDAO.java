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
import model.bean.TableUsuario;

/**
 *
 * @author Senai
 */
public class UsuarioDAO {
    public List<TableUsuario> read() {
        List<TableUsuario> usuarios = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM usuario");

            rs = stmt.executeQuery();

            while (rs.next()) {
                TableUsuario user = new TableUsuario();
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                user.setCpf(rs.getString("cpf"));
                user.setTelefone(rs.getString("telefone"));
                usuarios.add(user);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }
    
    public boolean create(TableUsuario user) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO usuario (nome, email, senha, cpf, telefone) VALUES (?,?,?,?,?)");
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getSenha());
            stmt.setString(4, user.getCpf());
            stmt.setString(5, user.getTelefone());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }      
    }
    
    public void update(TableUsuario user) {
        
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt;
            
            stmt = conexao.prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ?, cpf = ?, telefone = ?, WHERE id_usuario = ?");
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getSenha());
            stmt.setString(4, user.getCpf());
            stmt.setString(5, user.getTelefone());
            stmt.setInt(6, user.getId_usuario());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(TableUsuario user) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt;
            
            stmt = conexao.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
            stmt.setInt(1, user.getId_usuario());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public TableUsuario login (TableUsuario user){
        TableUsuario userLogin = new TableUsuario();
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE email = ? AND senha = ?");
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSenha());
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                userLogin.setId_usuario(rs.getInt("id_usuario"));
                userLogin.setEmail(rs.getString("email"));
                userLogin.setSenha(rs.getString("senha"));
            }
            
            rs.close();
            stmt.close();
            conexao.close();
            
        } catch (SQLException e){
            e.printStackTrace();
            userLogin.setId_usuario(0);
            userLogin.setEmail("");
            userLogin.setSenha("");
        }
        
        return userLogin;
    }
    
    public void validlogin (TableUsuario user){
        int login = 0;
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE email = ? AND senha = ?");
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSenha());
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                if(rs.getString("acesso").equals("cliente")){
                    TableUsuario.setAcessoStatic(2);
                }
                else if(rs.getString("acesso").equals("admin")){
                    TableUsuario.setAcessoStatic(1);
                }
                else{
                    TableUsuario.setAcessoStatic(0);
                }
                TableUsuario.setId_usuarioStatic(rs.getInt("id_usuario"));
            }
            
            rs.close();
            stmt.close();
            conexao.close();
            
        } catch (SQLException e){
       
        }
    }
    
    public int getId(String user){
        int id = 0;
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM usuario WHERE email = ?");
            stmt.setString(1, user);
            rs = stmt.executeQuery();
            if (rs.next()){
                id = rs.getInt("id_usuario");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
