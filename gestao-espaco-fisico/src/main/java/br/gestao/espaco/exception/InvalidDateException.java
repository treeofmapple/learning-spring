package br.gestao.espaco.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
@Data
public class InvalidDateException extends CustomGlobalException {

	private final String msg;
	
}
