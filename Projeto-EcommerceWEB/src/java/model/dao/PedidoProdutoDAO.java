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
import model.bean.TablePedidoProduto;

/**
 *
 * @author Senai
 */
public class PedidoProdutoDAO {
    public List<TablePedidoProduto> read() {
      List<TablePedidoProduto> pedidoProdutos = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM pedido_produto");

            rs = stmt.executeQuery();

            while (rs.next()) {
                TablePedidoProduto pp = new TablePedidoProduto();
                pp.setId_pedido_produto(rs.getInt("id_pedido_produto"));
                pp.setPedido_FK(rs.getInt("pedido_FK"));
                pp.setProduto_FK1(rs.getInt("produto_FK1"));
                pp.setQuantidade(rs.getInt("quantidade"));
                pp.setPreco_unitario(rs.getFloat("preco_unitario"));
                pedidoProdutos.add(pp);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidoProdutos;
    }
    
    public boolean create(TablePedidoProduto pp) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO pedido_produto (quantidade, preco_unitario) VALUES (?,?)");
            stmt.setInt(1, pp.getQuantidade());
            stmt.setFloat(2, pp.getPreco_unitario());
          
            stmt.executeUpdate();

            stmt.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }      
    }
    
    public void update(TablePedidoProduto pp) {
        
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt;
            
            stmt = conexao.prepareStatement("UPDATE pedido_produto SET quantidade = ?, SET preco_unitario = ?, WHERE id_pedido_produto = ?");
            stmt.setInt(1, pp.getQuantidade());
            stmt.setFloat(2, pp.getPreco_unitario());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(TablePedidoProduto pp){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt;
            
            stmt = conexao.prepareStatement("DELETE FROM pedido_produto WHERE id_pedido_produto = ?");
            stmt.setInt(1, pp.getId_pedido_produto());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
