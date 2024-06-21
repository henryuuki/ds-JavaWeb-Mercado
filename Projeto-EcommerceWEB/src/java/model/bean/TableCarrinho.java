/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Blob;
/**
 *
 * @author Usuário
 */
public class TableCarrinho {
    private int id_carrinho;
    private int usuario_FK;
    private int produto_FK;
    private byte[] imagemBytes;
    private String imagemBase64;
    private int quantidade;

    public TableCarrinho() {
    }

    public TableCarrinho(int id_carrinho, int usuario_FK, int produto_FK, int quantidade) {
        this.id_carrinho = id_carrinho;
        this.usuario_FK = usuario_FK;
        this.produto_FK = produto_FK;
        this.quantidade = quantidade;
    }

    public int getId_carrinho() {
        return id_carrinho;
    }

    public void setId_carrinho(int id_carrinho) {
        this.id_carrinho = id_carrinho;
    }

    public int getUsuario_FK() {
        return usuario_FK;
    }

    public void setUsuario_FK(int usuario_FK) {
        this.usuario_FK = usuario_FK;
    }

    public int getProduto_FK() {
        return produto_FK;
    }

    public void setProduto_FK(int produto_FK) {
        this.produto_FK = produto_FK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
}
