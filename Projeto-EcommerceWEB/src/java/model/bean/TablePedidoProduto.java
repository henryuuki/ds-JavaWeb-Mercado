package model.bean;

/**
 *
 * @author Senai
 */
public class TablePedidoProduto {
    private int id_pedido_produto;
    private int pedido_FK;
    private int produto_FK1;
    private int quantidade;
    private float preco_unitario;

    public TablePedidoProduto() {
    }

    public TablePedidoProduto(int id_pedido_produto, int pedido_FK, int produto_FK1, int quantidade, float preco_unitario) {
        this.id_pedido_produto = id_pedido_produto;
        this.pedido_FK = pedido_FK;
        this.produto_FK1 = produto_FK1;
        this.quantidade = quantidade;
        this.preco_unitario = preco_unitario;
    }

    public int getId_pedido_produto() {
        return id_pedido_produto;
    }

    public void setId_pedido_produto(int id_pedido_produto) {
        this.id_pedido_produto = id_pedido_produto;
    }

    public int getPedido_FK() {
        return pedido_FK;
    }

    public void setPedido_FK(int pedido_FK) {
        this.pedido_FK = pedido_FK;
    }

    public int getProduto_FK1() {
        return produto_FK1;
    }

    public void setProduto_FK1(int produto_FK1) {
        this.produto_FK1 = produto_FK1;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(float preco_unitario) {
        this.preco_unitario = preco_unitario;
    }
    
    
}
