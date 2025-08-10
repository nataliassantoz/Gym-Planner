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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name= "perfil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
