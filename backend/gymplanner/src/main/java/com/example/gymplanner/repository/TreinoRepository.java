package com.example.gymplanner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gymplanner.entity.Treino;

public interface TreinoRepository extends JpaRepository<Treino, Long>{

    List<Treino> findByUsuarioId(Long usuarioId);

}
