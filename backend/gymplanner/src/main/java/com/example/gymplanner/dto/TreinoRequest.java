package com.example.gymplanner.dto;

import com.example.gymplanner.enums.Semana;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TreinoRequest {
    
    @NotNull(message = "O dia da semana é obrigatório")
    private Semana diaSemana;
    
    @NotBlank(message = "A descrição não pode estar vazia")
    @Size(min = 3, max = 255, message = "A descrição não pode estar vazia")
    private String descricao;

    private Long usuarioId;
}
