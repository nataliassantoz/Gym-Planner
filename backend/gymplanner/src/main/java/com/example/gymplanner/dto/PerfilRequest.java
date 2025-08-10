package com.example.gymplanner.dto;

import com.example.gymplanner.enums.NivelAtividade;
import com.example.gymplanner.enums.Objetivo;
import com.example.gymplanner.enums.Sexo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PerfilRequest {

    @NotNull(message = "A altura é obrigatória")
    @Positive(message = "A altura deve ser positiva")
    private Double altura;

    @NotNull(message = "O peso é obrigatório")
    @Positive(message = "O peso deve ser positivo")
    private Double peso;

    @NotNull(message = "A idade é obrigatória")
    @Min(value = 1, message = "A idade deve ser maior que zero")
    @Max(value = 120, message = "A idade deve ser menor ou igual a 120")
    private Integer idade;

    @NotNull(message = "O sexo é obrigatório")
    private Sexo sexo;

    @NotNull(message = "O objetivo é obrigatório")
    private Objetivo objetivo;

    @NotNull(message = "O nível de atividade é obrigatório")
    private NivelAtividade nivel;

    private Long usuarioId;
}
