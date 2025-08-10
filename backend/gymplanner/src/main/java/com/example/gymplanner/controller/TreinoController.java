package com.example.gymplanner.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gymplanner.dto.TreinoRequest;
import com.example.gymplanner.entity.Treino;
import com.example.gymplanner.service.TreinoService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@RequestMapping("/treino")
@RequiredArgsConstructor
public class TreinoController {

    private final TreinoService treinoService;

    @PostMapping
    public Treino criarTreino(@RequestBody TreinoRequest request){

        return treinoService.cadastrarTreino(request);
    }



}
