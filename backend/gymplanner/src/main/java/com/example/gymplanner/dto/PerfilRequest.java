package com.example.gymplanner.dto;

import com.example.gymplanner.enums.NivelAtividade;
import com.example.gymplanner.enums.Objetivo;
import com.example.gymplanner.enums.Sexo;


public class PerfilRequest {

    private Double altura;
    private Double peso;
    private Integer idade;
    private Sexo sexo;
    private Objetivo objetivo;
    private NivelAtividade nivel;
    private Long usuarioId;
    
    public PerfilRequest(Double altura, Double peso, Integer idade, Sexo sexo, Objetivo objetivo,
            NivelAtividade nivel, Long usuario) {
        this.altura = altura;
        this.peso = peso;
        this.idade = idade;
        this.sexo = sexo;
        this.objetivo = objetivo;
        this.nivel = nivel;
        this.usuarioId = usuario;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public NivelAtividade getNivel() {
        return nivel;
    }

    public void setNivel(NivelAtividade nivel) {
        this.nivel = nivel;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuario(Long usuario) {
        this.usuarioId = usuario;
    }

    


}
