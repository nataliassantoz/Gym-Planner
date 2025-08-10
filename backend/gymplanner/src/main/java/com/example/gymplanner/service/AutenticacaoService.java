package com.example.gymplanner.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gymplanner.entity.Usuario;
import com.example.gymplanner.enums.TipoUsuario;
import com.example.gymplanner.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutenticacaoService {

    
    private UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    

    public AutenticacaoService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Usuario cadastrar(String email, String nome, String senha, TipoUsuario tipo){

        Optional<Usuario> emailInvalido = verificarEmail(email);

        if(emailInvalido.isPresent()){
            throw new IllegalArgumentException("Email já cadastrado!");
        }
        
        //criptografia de senha
        String senhaCriptografada = passwordEncoder.encode(senha);

        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setNome(nome);
        usuario.setSenha(senhaCriptografada);
        usuario.setTipo(tipo);
        usuario.setPerfil(null);

        return usuarioRepository.save(usuario);
    }

    public Usuario login(String email, String senha){

        Optional<Usuario> emailUsuario = verificarEmail(email);
        if(emailUsuario.isPresent()){
            
            Usuario usuario = emailUsuario.get();
            //comparacao das senhas
            if(passwordEncoder.matches(senha, usuario.getSenha())){
                System.out.println("Login bem-sucedido!");
                return usuario;
            }
            else{
                throw new RuntimeException("Senha incorreta");
            }
        }
        else{
            throw new RuntimeException("Usuário não encontrado");
        }     
    }

    public Optional<Usuario> verificarEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
}
