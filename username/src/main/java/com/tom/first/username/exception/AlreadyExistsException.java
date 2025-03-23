package com.tom.first.username.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
@Data
public class AlreadyExistsException extends RuntimeException {

	private final String msg;

}
