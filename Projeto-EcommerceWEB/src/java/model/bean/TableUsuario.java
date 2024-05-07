/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class TableUsuario {
    private int id_usuario;
    private static int id_usuarioStatic;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String telefone;
    private Timestamp data_registro; 
    private String acesso;
    private static int acessoStatic;

    public TableUsuario() {
    }

    public TableUsuario(int id_usuario, String nome, String email, String senha, String cpf, String telefone, Timestamp data_registro, String acesso) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
        this.data_registro = data_registro;
        this.acesso = acesso;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public static int getId_usuarioStatic() {
        return id_usuarioStatic;
    }

    public static void setId_usuarioStatic(int id_usuarioStatic) {
        TableUsuario.id_usuarioStatic = id_usuarioStatic;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Timestamp getData_registro() {
        return data_registro;
    }

    public void setData_registro(Timestamp data_registro) {
        this.data_registro = data_registro;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public static int getAcessoStatic() {
        return acessoStatic;
    }

    public static void setAcessoStatic(int acessoStatic) {
        TableUsuario.acessoStatic = acessoStatic;
    }

    
}
