package model.bean;

import java.sql.Timestamp;

/**
 *
 * @author Senai
 */
public class TablePedido {
    private int id_pedido;
    private int usuario_FK;
    private int endereco_FK;
    private Enum status;
    private Enum metodo_pagamento;
    private int valor_total;
    private Timestamp data_hora;

    public TablePedido() {
    }

    public TablePedido(int id_pedido, int usuario_FK, int endereco_FK, Enum status, Enum metodo_pagamento, int valor_total, Timestamp data_hora) {
        this.id_pedido = id_pedido;
        this.usuario_FK = usuario_FK;
        this.endereco_FK = endereco_FK;
        this.status = status;
        this.metodo_pagamento = metodo_pagamento;
        this.valor_total = valor_total;
        this.data_hora = data_hora;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getUsuario_FK() {
        return usuario_FK;
    }

    public void setUsuario_FK(int usuario_FK) {
        this.usuario_FK = usuario_FK;
    }

    public int getEndereco_FK() {
        return endereco_FK;
    }

    public void setEndereco_FK(int endereco_FK) {
        this.endereco_FK = endereco_FK;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public Enum getMetodo_pagamento() {
        return metodo_pagamento;
    }

    public void setMetodo_pagamento(Enum metodo_pagamento) {
        this.metodo_pagamento = metodo_pagamento;
    }

    public int getValor_total() {
        return valor_total;
    }

    public void setValor_total(int valor_total) {
        this.valor_total = valor_total;
    }

    public Timestamp getData_hora() {
        return data_hora;
    }

    public void setData_hora(Timestamp data_hora) {
        this.data_hora = data_hora;
    }
    
    
}
