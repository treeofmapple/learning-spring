package br.tekk.system.library.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
@Data
public class UserNotFoundException extends RuntimeException {

	private final String msg;
}