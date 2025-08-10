package com.example.gymplanner.dto;

public class LoginResponse {
    private String mensagem;
    private String nome;
    private Long id;
    private boolean perfilCompleto;

    public LoginResponse(String mensagem, String nome, Long id, Boolean perfilCompleto ){
        this.mensagem = mensagem;
        this.nome = nome;
        this.id = id;
        this.perfilCompleto = perfilCompleto;
    }

    public Boolean getPerfilCompleto() {
        return perfilCompleto;
    }

    public void setPerfilCompleto(Boolean perfilCompleto) {
        this.perfilCompleto = perfilCompleto;
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



    public boolean isPerfilCompleto() {
        return perfilCompleto;
    }



    public void setPerfilCompleto(boolean perfilCompleto) {
        this.perfilCompleto = perfilCompleto;
    }



}
