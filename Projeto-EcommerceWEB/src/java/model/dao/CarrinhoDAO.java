/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.TableCarrinho;
import model.bean.TableUsuario;

/**
 *
 * @author Usuário
 */
public class CarrinhoDAO {
    public boolean adicionar(TableCarrinho c) {
        try {

            Connection conexao = Conexao.conectar();
            
            if(produtoAddCarrinho(c.getProduto_FK(), TableUsuario.getId_usuarioStatic())){
                return false;
            }
            
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO carrinho (produto_FK, usuario_FK, quantidade,) values (?,?,?)");         
            
            
            stmt.setInt(1, c.getProduto_FK());
            stmt.setInt(2, c.getQuantidade());
            stmt.setInt(3, TableUsuario.getId_usuarioStatic());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<TableCarrinho> visualizarCarrinho() {

        List<TableCarrinho> carrinhos = new ArrayList<>();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(
                    "SELECT c.id_carrinho ,p.imagem AS imagem_produto, p.nome AS nome_produto, p.promocao AS promocao_produto, p.valor AS preco_produto, c.quantidade AS quantidade_pedido\n"
                    + "FROM carrinho c\n"
                    + "INNER JOIN produto p ON c.produto = p.id_produto\n"
                    + "WHERE c.usuario = ?;");

            stmt.setInt(1, TableUsuario.getId_usuarioStatic());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                TableCarrinho carrinho = new TableCarrinho();

                carrinho.setId_carrinho(rs.getInt("id_carrinho"));

                Blob imagemBlob = rs.getBlob("imagem_produto");
                if (imagemBlob != null) {
                    byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                    carrinho.setImagemBytes(imagemBytes);
                }
                carrinho.setNomeProduto(rs.getString("nome_produto"));
                float precoProduto = rs.getFloat("preco_produto");
                float promocaoProduto = rs.getFloat("promocao_produto");
                int quantidade = rs.getInt("quantidade_pedido");

                // Calculando o subtotal
                float subProduto = (precoProduto - promocaoProduto) * quantidade;

                // Definindo os valores no objeto Carrinho
                carrinho.setValorProduto(precoProduto - promocaoProduto);
                carrinho.setQuantidade(quantidade);
                carrinho.setSubProduto(subProduto);
                carrinho.setUsuario(Usuario.getIdUsuario());

                carrinhos.add(carrinho);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carrinhos;
    }

    public void excluirProdutoUnico(int idCarrinho) {

        try {

            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM carrinho WHERE idCarrinho = ?");

            stmt.setInt(1, idCarrinho);

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void excluirTodos(int idUsuario) {

        try {

            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM carrinho WHERE usuario = ?");

            stmt.setInt(1, idUsuario);

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void mudarQuantidade(int quantidade, int idCarrinho) {

        try {

            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("UPDATE carrinho SET quantidade = ? WHERE idCarrinho = ?");
            
            stmt.setInt(1, quantidade);
            stmt.setInt(2, idCarrinho);
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    private boolean produtoAddCarrinho(int idProduto, int idUsuario){
        
        boolean produtoAdd = false;
        
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("SELECT COUNT(*) FROM carrinho WHERE produto_FK = ? AND usuario_FK = ?");
            
            stmt.setInt(1, idProduto);
            stmt.setInt(2, idUsuario);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next() && rs.getInt(1) > 0){
                produtoAdd = true;
            }
            
            rs.close();
            stmt.close();
            conexao.close();            
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        return produtoAdd;
    }
    
    public boolean validaCarrinho(int idProduto) {
        boolean retorno = false;
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM carrinho where usuario = ? and produto = ?");
            stmt.setInt(1, TableUsuario.getId_usuarioStatic());
            stmt.setInt(2, idProduto);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                retorno = true;
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return retorno;
    }
}
