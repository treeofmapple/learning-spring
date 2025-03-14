package br.everest.hop.orm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.everest.hop.orm.exception.UsuarioNotFoundException;
import br.everest.hop.orm.exception.UsuarioNotFoundNotasException;
import br.everest.hop.orm.model.Avaliacao;
import br.everest.hop.orm.model.Usuario;
import br.everest.hop.orm.repository.UsuarioRepository;
import br.everest.hop.orm.request.dto.UsuarioMediaResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotasService {

    private final UsuarioRepository repository;

    public UsuarioMediaResponse calcularMediaUsuario(Long usuarioId) {
        var usuario = repository.findById(usuarioId).orElseThrow(
                () -> new UsuarioNotFoundException(String.format("Usuario not found with Id:: %s", usuarioId)));

        List<Avaliacao> avaliacoes = usuario.getAvaliacao();
        if (avaliacoes.isEmpty()) {
            throw new UsuarioNotFoundNotasException(String.format("Usuario has no avaliacoes", usuarioId));
        }

        double mediaNota = calcularMediaNotas(avaliacoes);
        return new UsuarioMediaResponse(usuario.getNome(), mediaNota);
    }

    public List<UsuarioMediaResponse> calcularMediaAllUsers() {
        List<Usuario> usuarios = repository.findAll();
        if (usuarios.isEmpty()) {
            throw new UsuarioNotFoundException("No users found.");
        }

        return usuarios.stream().map(this::mapping).collect(Collectors.toList());
    }

    private UsuarioMediaResponse mapping(Usuario usuario) {
        List<Avaliacao> avaliacoes = usuario.getAvaliacao();
        double mediaNota = 0.0;

        if (!avaliacoes.isEmpty()) {
            mediaNota = calcularMediaNotas(avaliacoes);
        }

        return new UsuarioMediaResponse(usuario.getNome(), mediaNota);
    }

    private double calcularMediaNotas(List<Avaliacao> avaliacoes) {
        double somaNotas = avaliacoes.stream().mapToDouble(Avaliacao::getNota).sum();
        return somaNotas / avaliacoes.size();
    }
}

