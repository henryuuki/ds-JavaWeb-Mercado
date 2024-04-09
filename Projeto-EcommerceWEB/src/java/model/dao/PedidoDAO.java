package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Calendar;
import model.bean.TablePedido;

public class PedidoDAO {
    public class UsuarioDAO {
        public List<TablePedido> read() {
            List<TablePedido> pedidos = new ArrayList();

            try {
                Connection conexao = Conexao.conectar();
                PreparedStatement stmt = null;
                ResultSet rs = null;

                stmt = conexao.prepareStatement("SELECT * FROM pedido");

                rs = stmt.executeQuery();

                while (rs.next()) {
                    TablePedido p = new TablePedido();
                    p.setId_pedido(rs.getInt("id_pedido"));
                    p.setUsuario_FK(rs.getInt("usuario_FK"));
                    p.setEndereco_FK(rs.getInt("endereco_FK"));
                    p.setStatus(rs.getString("status"));
                    p.setMetodo_pagamento(rs.getString("metodo_pagamento"));
                    p.setValor_total(rs.getInt("valor_total"));
                    p.setData_hora(rs.getTimestamp("data_hora"));
                    pedidos.add(p);
                }

                rs.close();
                stmt.close();
                conexao.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return pedidos;
        }

        public boolean create(TablePedido p) {
            try {
                Connection conexao = Conexao.conectar();
                PreparedStatement stmt = null;

                stmt = conexao.prepareStatement("INSERT INTO pedido (valor_total, data_hora) VALUES (?,?)");
                stmt.setInt(1, p.getValor_total());
                stmt.setTimestamp(2, p.getData_hora());

                stmt.executeUpdate();

                stmt.close();
                conexao.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }      
        }
    }
    
    public void update(TablePedido p) {
        
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt;
            
            stmt = conexao.prepareStatement("UPDATE pedido SET valor_total = ? WHERE id_pedido = ?");
            stmt.setInt(1, p.getValor_total());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(TablePedido p){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt;
            
            stmt = conexao.prepareStatement("DELETE FROM pedido WHERE id_pedido = ?");
            stmt.setInt(1, p.getId_pedido());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
