package com.example.gymplanner.dto;

import com.example.gymplanner.enums.NivelAtividade;
import com.example.gymplanner.enums.Objetivo;
import com.example.gymplanner.enums.Sexo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerfilRequest {

    private Double altura;
    private Double peso;
    private Integer idade;
    private Sexo sexo;
    private Objetivo objetivo;
    private NivelAtividade nivel;
    private Long usuarioId;
}
