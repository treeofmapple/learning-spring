package br.everest.hop.orm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.everest.hop.orm.exception.UsuarioAlreadyExistsException;
import br.everest.hop.orm.exception.UsuarioNotFoundException;
import br.everest.hop.orm.mapper.UsuarioMapper;
import br.everest.hop.orm.model.Usuario;
import br.everest.hop.orm.repository.UsuarioRepository;
import br.everest.hop.orm.request.UsuarioRequest;
import br.everest.hop.orm.request.UsuarioResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository repository;
	private final UsuarioMapper mapper;

	public List<UsuarioResponse> findAllUsuarios() {
		List<Usuario> usuario = repository.findAll();
		if (usuario.isEmpty()) {
			throw new UsuarioNotFoundException("No users found.");
		}
		return usuario.stream().map(mapper::fromUsuario).collect(Collectors.toList());
	}

	public UsuarioResponse findById(Long id) {
		return repository.findById(id).map(mapper::fromUsuario).orElseThrow(
				() -> new UsuarioNotFoundException(String.format("No user found with the provided ID:: %s", id)));
	}

	public Long createUsuario(UsuarioRequest request) {
		if (repository.existsByNome(request.nome())) {
			throw new UsuarioAlreadyExistsException(
					String.format("User with same nome already exists %s", request.nome()));
		}
		var usuario = repository.save(mapper.toUsuario(request));
		return usuario.getId();
	}

	public void updateUsuario(Long id, UsuarioRequest request) {
		var usuario = repository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(
				String.format("Cannot update User, no user found with the provided ID:: %s", id)));
		mergeUsuario(usuario, request);
		repository.save(usuario);
	}

	public void deleteUsuario(Long id) {
		if (!repository.existsById(id)) {
			throw new UsuarioNotFoundException("User not found with ID:: " + id);
		}
		repository.deleteById(id);
	}

	private void mergeUsuario(Usuario usuario, UsuarioRequest request) {
		usuario.setNome(request.nome());
	}

}
