package com.example.gymplanner.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gymplanner.dto.ErroResponse;
import com.example.gymplanner.dto.PerfilRequest;
import com.example.gymplanner.dto.PerfilResponse;
import com.example.gymplanner.entity.Perfil;
import com.example.gymplanner.entity.Usuario;
import com.example.gymplanner.repository.UsuarioRepository;
import com.example.gymplanner.service.PerfilService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public PerfilController(PerfilService perfilService, UsuarioRepository usuarioRepository) {
        this.perfilService = perfilService;
        this.usuarioRepository  = usuarioRepository;
    }

    @PostMapping("/cadastrarPerfil")
    public ResponseEntity<?> cadastrarPerfil(@RequestBody PerfilRequest request){

    try{

        Optional<Usuario> usuario = usuarioRepository.findById(request.getUsuarioId());

        if(usuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErroResponse("Usuário não encontrado"));
        }

        Perfil novoPerfil = perfilService.cadastrarPerfil(
            request.getAltura(),
            request.getPeso(),
            request.getIdade(),
            request.getSexo(),
            request.getObjetivo(),
            request.getNivel(),
            usuario.get()
        );

        PerfilResponse resposta = new PerfilResponse("Dados salvos com sucesso!");
        return ResponseEntity.ok(resposta);
        
    }
    catch( RuntimeException e){
        ErroResponse respostaErro = new ErroResponse("Erro ao salvar dados! Entre em contato com o suporte. ");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respostaErro);
    }
    }
}
