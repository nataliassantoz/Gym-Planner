package com.example.gymplanner.controller.autenticacaoController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gymplanner.dto.LoginRequest;
import com.example.gymplanner.dto.RegistroRequest;
import com.example.gymplanner.entity.Usuario;
import com.example.gymplanner.service.auth.AutenticacaoService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private final AutenticacaoService autenticacaoService;

    public AutenticacaoController(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }

    
    @PostMapping("/registro")
    public ResponseEntity<Usuario> cadastrar(@RequestBody RegistroRequest request){

        Usuario novoUsuario = autenticacaoService.cadastrar(
            request.getEmail(),
            request.getNome(),
            request.getSenha(),
            request.getTipo()
        );
        return ResponseEntity.ok(novoUsuario);
        
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){

        try{
            autenticacaoService.login(request.getEmail(), request.getSenha());
            return ResponseEntity.ok("login bem sucedido!");
        }
        catch( RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());

        }
    }

}
