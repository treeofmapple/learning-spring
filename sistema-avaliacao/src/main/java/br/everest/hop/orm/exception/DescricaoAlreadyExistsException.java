package br.everest.hop.orm.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
@Data
public class DescricaoAlreadyExistsException extends RuntimeException {

	private final String msg;

}
