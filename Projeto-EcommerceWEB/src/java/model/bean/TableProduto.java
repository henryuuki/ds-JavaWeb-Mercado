package model.bean;

import java.sql.Blob;

/**
 *
 * @author Senai
 */
public class TableProduto {
    private int id_produto;
    private static int idStaticProduto;
    private int categoria_FK;
    private String nome;
    private String descricao;
    private byte[] imagemBytes;
    private String imagemBase64;
    private float valor;

    public TableProduto() {
    }

    public TableProduto(int id_produto, int categoria_FK, String nome, String descricao, byte[] imagemBytes, String imagemBase64, float valor) {
        this.id_produto = id_produto;
        this.categoria_FK = categoria_FK;
        this.nome = nome;
        this.descricao = descricao;
        this.imagemBytes = imagemBytes;
        this.imagemBase64 = imagemBase64;
        this.valor = valor;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public static int getIdStaticProduto() {
        return idStaticProduto;
    }

    public static void setIdStaticProduto(int idStaticProduto) {
        TableProduto.idStaticProduto = idStaticProduto;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    
    
}