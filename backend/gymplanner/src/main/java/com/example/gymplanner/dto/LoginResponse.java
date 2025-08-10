package com.example.gymplanner.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LoginResponse {
    private String mensagem;
    private String nome;
    private Long id;
    private boolean perfilCompleto;
}
