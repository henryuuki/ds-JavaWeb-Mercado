package model.bean;

/**
 *
 * @author Senai
 */
public class TableEstoque {
    private int id_estoque;
    private int produto_FK2;
    private int quantidade_estoque;

    public TableEstoque() {
    }

    public TableEstoque(int id_estoque, int produto_FK2, int quantidade_estoque) {
        this.id_estoque = id_estoque;
        this.produto_FK2 = produto_FK2;
        this.quantidade_estoque = quantidade_estoque;
    }

    public int getId_estoque() {
        return id_estoque;
    }

    public void setId_estoque(int id_estoque) {
        this.id_estoque = id_estoque;
    }

    public int getProduto_FK2() {
        return produto_FK2;
    }

    public void setProduto_FK2(int produto_FK2) {
        this.produto_FK2 = produto_FK2;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }
    
    
}
