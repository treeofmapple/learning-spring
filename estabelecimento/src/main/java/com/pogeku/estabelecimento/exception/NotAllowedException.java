package com.pogeku.estabelecimento.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
@Data
public class NotAllowedException extends CustomGlobalException {

	private final String msg;
	
}
