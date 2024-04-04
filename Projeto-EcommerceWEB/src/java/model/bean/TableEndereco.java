package model.bean;

/**
 *
 * @author Senai
 */
public class TableEndereco {
    private int id_endereco;
    private String rua;
    private int numero;
    private int cep;
    private String complemento;

    public TableEndereco() {
    }

    public TableEndereco(int id_endereco, String rua, int numero, int cep, String complemento) {
        this.id_endereco = id_endereco;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
}
