package com.example.gymplanner.dto;

public class PerfilResponse {

    private String mensagem;
    
    public PerfilResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}


