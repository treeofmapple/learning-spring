package com.pogeku.veiculo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
@Data
public class UnavailableException extends CustomGlobalException {

	private final String msg;
	
}
