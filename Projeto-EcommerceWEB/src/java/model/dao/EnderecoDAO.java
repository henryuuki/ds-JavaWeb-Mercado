package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.TableEndereco;

public class EnderecoDAO {
    public List<TableEndereco> read() {
        List<TableEndereco> enderecos = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM endereço");

            rs = stmt.executeQuery();

            while (rs.next()) {
                TableEndereco en = new TableEndereco();
                en.setId_endereco(rs.getInt("id_endereco"));
                en.setRua(rs.getString("rua"));
                en.setNumero(rs.getInt("numero"));
                en.setCep(rs.getInt("cep"));
                en.setComplemento(rs.getString("complemento"));
                enderecos.add(en);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enderecos;
    }
    
    public boolean create(TableEndereco en) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO endereço (rua, numero, cep, complemento) VALUES (?,?,?,?)");
            stmt.setString(1, en.getRua());
            stmt.setInt(2, en.getNumero());
            stmt.setInt(3, en.getCep());
            stmt.setString(4, en.getComplemento());
          
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }      
    }
    
    public void update(TableEndereco en) {
        
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt;
            
            stmt = conexao.prepareStatement("UPDATE endereço SET rua = ?, numero = ?, cep = ?, complemento = ?, WHERE id_endereco = ?");
            stmt.setString(1, en.getRua());
            stmt.setInt(2, en.getNumero());
            stmt.setInt(3, en.getCep());
            stmt.setString(4, en.getComplemento());
            stmt.setInt(5, en.getId_endereco());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(TableEndereco en){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt;
            
            stmt = conexao.prepareStatement("DELETE FROM usuario WHERE id_endereco = ?");
            stmt.setInt(1, en.getId_endereco());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
