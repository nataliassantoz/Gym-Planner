package com.example.gymplanner.entity;

import com.example.gymplanner.enums.TipoUsuario;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name= "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String nome;

    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;   
    
    @OneToOne(mappedBy= "usuario")
    private Perfil perfil;

    public Usuario() {} 

    public Usuario(Long id, String email, String nome, String senha, TipoUsuario tipo,  Perfil perfil) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setTipo(TipoUsuario tipo){
        this.tipo = tipo;
    }

    public TipoUsuario getTipo(){
        return tipo;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
}
