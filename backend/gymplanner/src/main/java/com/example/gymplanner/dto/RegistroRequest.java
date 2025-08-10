package com.example.gymplanner.dto;

import com.example.gymplanner.enums.TipoUsuario;

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
public class RegistroRequest {

    private String email;
    private String nome;
    private String senha;
    private TipoUsuario tipo;
}
