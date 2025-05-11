package com.example.gymplanner.dto;

import com.example.gymplanner.enums.TipoUsuario;

public class RegistroRequest {

    private String email;
    private String nome;
    private String senha;
    private TipoUsuario tipo;
    
    public RegistroRequest(String email, String nome, String senha, TipoUsuario tipo) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    
}
