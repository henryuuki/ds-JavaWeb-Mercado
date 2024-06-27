package model.bean;

/**
 *
 * @author Senai
 */
public class TableEndereco {
    private int id_endereco;
    private static int id_enderecoStatic;
    private String rua;
    private String numero;
    private String cep;
    private String complemento;
    private int usuario_FK;

    public TableEndereco() {
    }

    public TableEndereco(int id_endereco, String rua, String numero, String cep, String complemento, int usuario_FK) {
        this.id_endereco = id_endereco;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
        this.usuario_FK = usuario_FK;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public static int getId_enderecoStatic() {
        return id_enderecoStatic;
    }

    public static void setId_enderecoStatic(int id_enderecoStatic) {
        TableEndereco.id_enderecoStatic = id_enderecoStatic;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getUsuario_FK() {
        return usuario_FK;
    }

    public void setUsuario_FK(int usuario_FK) {
        this.usuario_FK = usuario_FK;
    }

    
    
}
