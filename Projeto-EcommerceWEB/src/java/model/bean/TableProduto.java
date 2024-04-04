package model.bean;

import java.sql.Blob;

/**
 *
 * @author Senai
 */
public class TableProduto {
    private int id_produto;
    private int categoria_FK;
    private String nome;
    private Blob imagem;
    private float valor;

    public TableProduto() {
    }

    public TableProduto(int id_produto, int categoria_FK, String nome, Blob imagem, float valor) {
        this.id_produto = id_produto;
        this.categoria_FK = categoria_FK;
        this.nome = nome;
        this.imagem = imagem;
        this.valor = valor;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getCategoria_FK() {
        return categoria_FK;
    }

    public void setCategoria_FK(int categoria_FK) {
        this.categoria_FK = categoria_FK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Blob getImagem() {
        return imagem;
    }

    public void setImagem(Blob imagem) {
        this.imagem = imagem;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
}
