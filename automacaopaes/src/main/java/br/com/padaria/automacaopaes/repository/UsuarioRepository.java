package br.com.padaria.automacaopaes.repository;

import br.com.padaria.automacaopaes.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAllByNome(String nome);
    Integer deleteByNome(String nome);
}
