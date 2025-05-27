package com.example.gymplanner.controller.autenticacaoController;

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
import com.example.gymplanner.service.auth.AutenticacaoService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@RequestMapping("/auth")
public class AutenticacaoController {

    private final AutenticacaoService autenticacaoService;

    public AutenticacaoController(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }

    
    @PostMapping("/registro")
    public ResponseEntity<LoginResponse> cadastrar(@RequestBody RegistroRequest request){

        Usuario novoUsuario = autenticacaoService.cadastrar(
            request.getEmail(),
            request.getNome(),
            request.getSenha(),
            request.getTipo()
        );

        LoginResponse resposta = new LoginResponse(
            "Cadastro bem sucedido!",
            novoUsuario.getNome()
        );
        
        return ResponseEntity.ok(resposta);
        
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){

        try{
           Usuario usuario =  autenticacaoService.login(request.getEmail(), request.getSenha());

           LoginResponse resposta = new LoginResponse(
            "Login bem sucedido!",
            usuario.getNome()
        );
        
            return ResponseEntity.ok(resposta);
        }
        catch( RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErroResponse(e.getMessage()));

        }
    }

}
