package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.TableEndereco;
import model.bean.TableUsuario;

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
                en.setCep(rs.getString("cep"));
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
            stmt.setString(3, en.getCep());
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
            stmt.setString(3, en.getCep());
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
            
            stmt = conexao.prepareStatement("DELETE FROM pedido WHERE id_endereco = ?");
            stmt.setInt(1, en.getId_endereco());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public TableEndereco mostrarCheckout(){

        TableEndereco e = new TableEndereco();

        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("SELECT rua, cep, id_endereco FROM endereco WHERE usuario = ? AND endereco_padrao = true");
            ResultSet rs = null;

            stmt.setInt(1, TableUsuario.getId_usuarioStatic());

            rs = stmt.executeQuery();

            while(rs.next()){
                e.setRua(rs.getString("rua"));
                e.setCep(rs.getString("cep"));
                TableEndereco.setId_enderecoStatic(rs.getInt("id_endereco"));
            }

            rs.close();
            stmt.close();
            conexao.close();

            }catch(SQLException ed){
                ed.printStackTrace();

        }

        return e;
    }
    
    public List<TableEndereco> visualizarEnderecos(){

        List<TableEndereco> e = new ArrayList();

        try{

            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM endereco WHERE usuario = ?");
            ResultSet rs = null;

            stmt.setInt(1,TableUsuario.getId_usuarioStatic());

            rs = stmt.executeQuery();

            while(rs.next()){
                TableEndereco endereco = new TableEndereco();

                endereco.setId_endereco(rs.getInt("id_endereco"));
                endereco.setRua(rs.getString("rua"));
                endereco.setCep(rs.getString("cep"));
                e.add(endereco);

            }
            rs.close();
            stmt.close();
            conexao.close();

        }catch(SQLException ed){
            ed.printStackTrace();
        }
        return e;
    }
}
