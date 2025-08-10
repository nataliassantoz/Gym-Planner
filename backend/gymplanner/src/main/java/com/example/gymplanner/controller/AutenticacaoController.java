package com.example.gymplanner.controller;

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
import com.example.gymplanner.dto.LoginRequest;
import com.example.gymplanner.dto.LoginResponse;
import com.example.gymplanner.dto.RegistroRequest;
import com.example.gymplanner.entity.Usuario;
import com.example.gymplanner.service.AutenticacaoService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    public AutenticacaoController(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/registro")
    public ResponseEntity<?> cadastrar(@RequestBody RegistroRequest request){

        try{
            Usuario novoUsuario = autenticacaoService.cadastrar(
                request.getEmail(),
                request.getNome(),
                request.getSenha(),
                request.getTipo()
            );
            //retornando o id para a criacao de  perfil ***
            LoginResponse resposta = new LoginResponse(
                "Cadastro bem sucedido!",
                novoUsuario.getNome(),
                novoUsuario.getId(),  //retorna o id pro front
                false
            );
            return ResponseEntity.ok(resposta);
        }
        catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErroResponse(e.getMessage()));
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){

        try{
           Usuario usuario =  autenticacaoService.login(request.getEmail(), request.getSenha());

           boolean perfilCompleto = (usuario.getPerfil() != null); // true se já cadastrou perfil

           LoginResponse resposta = new LoginResponse(
            "Login bem sucedido!",
            usuario.getNome(),
            usuario.getId(),
            perfilCompleto 
        );
            return ResponseEntity.ok(resposta);
        }
        catch( RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErroResponse(e.getMessage()));
        }
    }
}
