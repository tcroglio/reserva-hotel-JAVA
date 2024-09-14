package model;

import java.util.Date;

/**
 * @author tiago
 */
public class User {
   
    private int id_usuario;
    private String nome;
    private String email;
    private String senha;
    private Date dataNasc;
    private boolean ativo;

    public User() {}

    @Override
    public String toString() {
        return "User{" + "id_usuario=" + id_usuario + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", dataNasc=" + dataNasc + ", ativo=" + ativo + '}';
    }
    
    public User(int id_usuario, String nome, String email, String senha, Date dataNasc, boolean ativo) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.ativo = ativo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String ativoToString() {
        if (isAtivo()) {
            return "Ativo";
            
        } else {
            return "Inativo";
        }
    }
}
