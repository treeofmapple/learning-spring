package br.everest.hop.orm.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
@Data
public class UsuarioNotFoundException extends RuntimeException {

	private final String msg;
}
