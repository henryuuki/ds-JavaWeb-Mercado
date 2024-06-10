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
import model.bean.TableProduto;

/**
 *
 * @author Senai
 */
public class ProdutoDAO {

    public List<TableProduto> read() {
        List<TableProduto> produtos = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM produto");

            rs = stmt.executeQuery();

            while (rs.next()) {
                TableProduto p = new TableProduto();
                p.setId_produto(rs.getInt("id_produto"));
                p.setCategoria_FK(rs.getInt("categoria_FK"));
                p.setNome(rs.getString("nome"));
                p.setNome(rs.getString("descricao"));
                p.setImagemBytes(rs.getBytes("imagem"));
                p.setValor(rs.getFloat("valor"));
                produtos.add(p);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }

    public boolean create(TableProduto p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("INSERT INTO produto (nome, descricao, imagem, valor) VALUES (?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setBytes(3, p.getImagemBytes());
            stmt.setFloat(4, p.getValor());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean inserirProduto(TableProduto produto) {
        try (Connection conexao = Conexao.conectar();
                PreparedStatement ps = conexao.prepareStatement("INSERT INTO produto (nome, valor, categoria_FK, imagem, descricao) VALUES (?, ?, ?, ?, ?)")) {

            ps.setString(1, produto.getNome());
            ps.setFloat(2, produto.getValor());
            ps.setInt(3, produto.getCategoria_FK());
            ps.setBytes(4, produto.getImagemBytes());
            ps.setString(5, produto.getDescricao());

            int linhasAfetadas = ps.executeUpdate();
            ps.close();
            conexao.close();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<TableProduto> listarPorCategoria(int c) {
        List<TableProduto> produtos = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String query = "SELECT * FROM produto WHERE categoria_FK = ?";

            stmt = conexao.prepareStatement(query);
            stmt.setInt(1, c);

            rs = stmt.executeQuery();

            while (rs.next()) {
                TableProduto p = new TableProduto();
                p.setId_produto(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setCategoria_FK(rs.getInt("categoria_FK"));
                p.setValor(rs.getFloat("valor"));
                p.setDescricao(rs.getString("descricao"));

                Blob imagemBlob = rs.getBlob("imagem");
                if (imagemBlob != null) {
                    byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                    p.setImagemBytes(imagemBytes);
                }
                produtos.add(p);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public List<TableProduto> listarTodosP() {
        List<TableProduto> produtos = new ArrayList<>();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement("SELECT * FROM produto");

            rs = stmt.executeQuery();

            while (rs.next()) {
                TableProduto p = new TableProduto();
                p.setId_produto(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setCategoria_FK(rs.getInt("categoria_FK"));
                p.setValor(rs.getFloat("valor"));
                p.setDescricao(rs.getString("descricao"));

                Blob imagemBlob = rs.getBlob("imagem");
                if (imagemBlob != null) {
                    byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                    p.setImagemBytes(imagemBytes);
                }
                produtos.add(p);
            }

            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return produtos;
    }

    public TableProduto readById(int id) {
        TableProduto p = null;

        try (Connection conexao = Conexao.conectar();
                PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM produto WHERE id_Produto = ?")) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    p = new TableProduto();
                    p.setId_produto(rs.getInt("id_produto"));
                    p.setNome(rs.getString("nome"));
                    p.setCategoria_FK(rs.getInt("categoria_FK"));
                    p.setValor(rs.getFloat("valor"));
                    p.setDescricao(rs.getString("descricao"));

                    Blob imagemBlob = rs.getBlob("imagem");
                    if (imagemBlob != null) {
                        byte[] imagemBytes = imagemBlob.getBytes(1, (int) imagemBlob.length());
                        p.setImagemBytes(imagemBytes);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void update(TableProduto p) {

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt;

            stmt = conexao.prepareStatement("UPDATE produto SET nome = ?, SET descricao = ?, SET imagem = ?, SET valor = ?, WHERE id_produto = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setBytes(3, p.getImagemBytes());
            stmt.setFloat(4, p.getValor());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(TableProduto p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt;

            stmt = conexao.prepareStatement("DELETE FROM produto WHERE id_produto = ?");
            stmt.setInt(1, p.getId_produto());

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
