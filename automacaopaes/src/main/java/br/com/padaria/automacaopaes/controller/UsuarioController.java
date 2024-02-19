package br.com.padaria.automacaopaes.controller;

import br.com.padaria.automacaopaes.dto.UsuarioCreateDto;
import br.com.padaria.automacaopaes.dto.UsuarioUpdateDto;
import br.com.padaria.automacaopaes.entity.Usuario;
import br.com.padaria.automacaopaes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioService service;

    
    @PostMapping("/create-user")
    public ResponseEntity createUsuario(@RequestBody UsuarioCreateDto dto) {

        Usuario usuario = service.createUser(dto);
        if (usuario != null) return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        return ResponseEntity.badRequest().build();

    }

    @PutMapping("/update-user")
    public ResponseEntity updateUsuario(@RequestBody UsuarioUpdateDto dto){

        Optional<Usuario> usuario = service.updateUser(dto);
        if (usuario.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/find-all-by-nome/{nome}")
    public ResponseEntity findAllByNome(@PathVariable String nome){

        List<Usuario> usuarios = service.getUsuarioPorNome(nome);
        if (usuarios.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(usuarios);
    
    }

    @DeleteMapping("/delete-by-nome/{nome}")
    public ResponseEntity deleteByNome(@PathVariable String nome){

        Boolean usuarioFoiDeletado = service.deleteUsuarioPorNome(nome);
        if (usuarioFoiDeletado) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    
    }
}
