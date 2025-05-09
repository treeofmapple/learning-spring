package com.tom.first.simple.exception;

import com.tom.first.simple.exception.global.CustomGlobalException;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
@Data
public class AlreadyExistsException extends CustomGlobalException {

	private final String msg;
	
}
