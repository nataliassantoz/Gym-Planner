package com.example.gymplanner.entity;

import com.example.gymplanner.enums.NivelAtividade;
import com.example.gymplanner.enums.Objetivo;
import com.example.gymplanner.enums.Sexo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name= "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Double altura;
    private Double peso;
    private Integer idade;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Enumerated(EnumType.STRING)
    private Objetivo objetivo;
    @Enumerated(EnumType.STRING)
    private NivelAtividade nivel;

    @OneToOne
    @JoinColumn(name= "usuario_id")
    private Usuario usuario;

    public Perfil() {}

    public Perfil(Long id, Double altura, Double peso, Integer idade, Sexo sexo, Objetivo objetivo,
            NivelAtividade nivel, Usuario usuario) {
        this.id = id;
        this.altura = altura;
        this.peso = peso;
        this.idade = idade;
        this.sexo = sexo;
        this.objetivo = objetivo;
        this.nivel = nivel;
        this.usuario = usuario;
    }

    public Long getId() {
        Usuario u = new Usuario();
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
