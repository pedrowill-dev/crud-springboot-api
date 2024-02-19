package br.com.padaria.automacaopaes.service;

import br.com.padaria.automacaopaes.dto.UsuarioCreateDto;
import br.com.padaria.automacaopaes.dto.UsuarioUpdateDto;
import br.com.padaria.automacaopaes.entity.Usuario;
import br.com.padaria.automacaopaes.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public List<Usuario> getUsuarioPorNome(String nome) {
        return repository.findAllByNome(nome);
    }

    @Transactional
    public Boolean deleteUsuarioPorNome(String nome) {
        return repository.deleteByNome(nome) > 0;
    }


    @Transactional
    public Optional<Usuario> updateUser(UsuarioUpdateDto dto){

        Optional<Usuario> usuarioUpdate = repository.findById(dto.getId());

        if (usuarioUpdate.isPresent()) {
            Usuario usuario = usuarioUpdate.get();
            Usuario userUpdate = Usuario.builder()
                    .id(usuario.getId())
                    .nome(dto.getNome())
                    .dtNascimento(dto.getDtNascimento())
                    .build();
            return Optional.of(repository.save(userUpdate));
        }
        return Optional.empty();
    }

    public Usuario createUser(UsuarioCreateDto dto) {
        Usuario usuario = Usuario.builder()
                .nome(dto.getNome())
                .dtNascimento(dto.getDtNascimento())
                .build();
        return repository.save(usuario);
    }
}
