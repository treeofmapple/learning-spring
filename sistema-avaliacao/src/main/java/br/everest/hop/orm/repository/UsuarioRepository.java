package br.everest.hop.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.everest.hop.orm.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	boolean existsByNome(String nome);

	Usuario findByNome(String nome);
}
