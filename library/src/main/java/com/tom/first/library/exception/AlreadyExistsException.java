package com.tom.first.library.exception;

import com.tom.first.library.exception.global.CustomGlobalException;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
@Data
public class AlreadyExistsException extends CustomGlobalException {

	private final String msg;
	
}
