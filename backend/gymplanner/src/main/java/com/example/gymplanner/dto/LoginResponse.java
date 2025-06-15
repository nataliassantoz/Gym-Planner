package com.example.gymplanner.dto;

public class LoginResponse {
    private String mensagem;
    private String nome;
    private Long id;

    public LoginResponse(String mensagem, String nome, Long id) {
        this.mensagem = mensagem;
        this.nome = nome;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}
