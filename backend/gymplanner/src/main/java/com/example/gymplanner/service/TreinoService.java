package com.example.gymplanner.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gymplanner.dto.TreinoRequest;
import com.example.gymplanner.entity.Treino;
import com.example.gymplanner.repository.PerfilRepository;
import com.example.gymplanner.repository.TreinoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final PerfilRepository perfilRepository;

    private final TreinoRepository treinoRepository;

    public Treino cadastrarTreino(TreinoRequest request){
        Treino treino = new Treino();

        treino.setDiaSemana(request.getDiaSemana());
        treino.setDescricao(request.getDescricao());
        treino.setUsuarioId(request.getUsuarioId());

        return treinoRepository.save(treino);                                                                                                                                                      
    }

    public List<Treino> listarTreinos(Long usuarioId) {
        return treinoRepository.findByUsuarioId(usuarioId);
    }

    public void excluirTreino(Long treinoId) {
        treinoRepository.deleteById(treinoId);
    }
}
