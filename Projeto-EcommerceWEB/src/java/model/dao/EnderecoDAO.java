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

            stmt = conexao.prepareStatement("SELECT * FROM endereco");

            rs = stmt.executeQuery();

            while (rs.next()) {
                TableEndereco en = new TableEndereco();
                en.setId_endereco(rs.getInt("id_endereco"));
                en.setRua(rs.getString("rua"));
                en.setNumero(rs.getString("numero"));
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

            stmt = conexao.prepareStatement("INSERT INTO endereco (rua, numero, cep, complemento, usuario_FK) VALUES (?,?,?,?,?)");
            stmt.setString(1, en.getRua());
            stmt.setString(2, en.getNumero());
            stmt.setString(3, en.getCep());
            stmt.setString(4, en.getComplemento());
            stmt.setInt(5, en.getUsuario_FK());
          
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
            
            stmt = conexao.prepareStatement("UPDATE endereco SET rua = ?, numero = ?, cep = ?, complemento = ?, WHERE id_endereco = ?");
            stmt.setString(1, en.getRua());
            stmt.setString(2, en.getNumero());
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
            
            stmt = conexao.prepareStatement("DELETE FROM endereço WHERE id_endereco = ?");
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
            PreparedStatement stmt = conexao.prepareStatement("SELECT rua, numero, cep, complemento, id_endereco FROM endereco WHERE usuario_FK = ?");
            ResultSet rs = null;

            stmt.setInt(1, TableUsuario.getId_usuarioStatic());

            rs = stmt.executeQuery();

            if(rs.next()){
                e.setRua(rs.getString("rua"));
                e.setNumero(rs.getString("numero"));
                e.setCep(rs.getString("cep"));
                e.setComplemento(rs.getString("complemento"));
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
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM endereco WHERE usuario_FK = ?");
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
