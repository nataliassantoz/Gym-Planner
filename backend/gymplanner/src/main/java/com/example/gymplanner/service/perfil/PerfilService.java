package com.example.gymplanner.service.perfil;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.gymplanner.entity.Perfil;
import com.example.gymplanner.entity.Usuario;
import com.example.gymplanner.enums.NivelAtividade;
import com.example.gymplanner.enums.Objetivo;
import com.example.gymplanner.enums.Sexo;
import com.example.gymplanner.repository.PerfilRepository;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public Perfil cadastrarPerfil(Double altura, Double peso, Integer idade, Sexo sexo, Objetivo objetivo, NivelAtividade nivel, Usuario usuario){
        Perfil perfil = new Perfil();
        
        perfil.setAltura(altura);
        perfil.setPeso(peso);
        perfil.setIdade(idade);
        perfil.setSexo(sexo);
        perfil.setObjetivo(objetivo);
        perfil.setNivel(nivel);
        perfil.setUsuario(usuario);

        return perfilRepository.save(perfil);
    }


    public Optional<Perfil> encontrarPerfil(Long id){ //deve chamar o metodo encontrar id no controller e depois setar o usuario e chamar o metodo cadastrar perfil

        Optional<Perfil> perfilEncontrado = perfilRepository.findById(id);

        if(perfilEncontrado.isPresent()){
                return perfilEncontrado;
        }
        else{
           return Optional.empty();
        }
    }

    public Optional<Perfil> atualizarPeso(Long id, Double novoPeso){
        
        Optional<Perfil> perfilEncontrado = encontrarPerfil(id);
        if(perfilEncontrado.isPresent()){
            Perfil perfilAtualizado = perfilEncontrado.get();
            perfilAtualizado.setPeso(novoPeso);
            perfilRepository.save(perfilAtualizado); 
            return Optional.of(perfilAtualizado);
        }
        else{
           return Optional.empty();
        }
    }

     public Optional<Perfil> atualizarIdade(Long id, Integer novaIdade){
        
        Optional<Perfil> perfilEncontrado = encontrarPerfil(id);
        if(perfilEncontrado.isPresent()){
            Perfil perfilAtualizado = perfilEncontrado.get();
            perfilAtualizado.setIdade(novaIdade);
            perfilRepository.save(perfilAtualizado); 
            return Optional.of(perfilAtualizado);
        }
        else{
           return Optional.empty();
        }
    }

  public Optional<Perfil> atualizarObjetivo(Long id, Objetivo objetivo){
        
        Optional<Perfil> perfilEncontrado = encontrarPerfil(id);
        if(perfilEncontrado.isPresent()){
            Perfil perfilAtualizado = perfilEncontrado.get();
            perfilAtualizado.setObjetivo(objetivo);
            perfilRepository.save(perfilAtualizado); 
            return Optional.of(perfilAtualizado);
        }
        else{
           return Optional.empty();
        }
    }

      public Optional<Perfil> atualizarNivelAtividade(Long id, NivelAtividade nivel){
        
        Optional<Perfil> perfilEncontrado = encontrarPerfil(id);
        if(perfilEncontrado.isPresent()){
            Perfil perfilAtualizado = perfilEncontrado.get();
            perfilAtualizado.setNivel(nivel);
            perfilRepository.save(perfilAtualizado); 
            return Optional.of(perfilAtualizado);
        }
        else{
           return Optional.empty();
        }
    }

   
}
