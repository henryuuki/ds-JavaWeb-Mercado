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
    private TableUsuario usuario_FK;
    private TableProduto produto_FK;
    private int quantidade;
    private float subProduto;
    private float subTotal;
    private String descricao;
    private String nomeProduto;
    private Float valorProduto;
    private byte[] imagemBytes;
    private String imagemBase64;

    public TableCarrinho() {
    }

    public TableCarrinho(int id_carrinho, TableUsuario usuario_FK, TableProduto produto_FK, int quantidade, float subProduto, float subTotal, String descricao, String nomeProduto, Float valorProduto, byte[] imagemBytes, String imagemBase64) {
        this.id_carrinho = id_carrinho;
        this.usuario_FK = usuario_FK;
        this.produto_FK = produto_FK;
        this.quantidade = quantidade;
        this.subProduto = subProduto;
        this.subTotal = subTotal;
        this.descricao = descricao;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.imagemBytes = imagemBytes;
        this.imagemBase64 = imagemBase64;
    }

    public int getId_carrinho() {
        return id_carrinho;
    }

    public void setId_carrinho(int id_carrinho) {
        this.id_carrinho = id_carrinho;
    }

    public TableUsuario getUsuario_FK() {
        return usuario_FK;
    }

    public void setUsuario_FK(TableUsuario usuario_FK) {
        this.usuario_FK = usuario_FK;
    }

    public TableProduto getProduto_FK() {
        return produto_FK;
    }

    public void setProduto_FK(TableProduto produto_FK) {
        this.produto_FK = produto_FK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getSubProduto() {
        return subProduto;
    }

    public void setSubProduto(float subProduto) {
        this.subProduto = subProduto;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Float valorProduto) {
        this.valorProduto = valorProduto;
    }

    public byte[] getImagemBytes() {
        return imagemBytes;
    }

    public void setImagemBytes(byte[] imagemBytes) {
        this.imagemBytes = imagemBytes;
    }

    public String getImagemBase64() {
        return imagemBase64;
    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }

    
}
