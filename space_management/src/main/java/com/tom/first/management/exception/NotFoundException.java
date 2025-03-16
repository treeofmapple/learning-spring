package com.tom.first.management.exception;

import com.tom.first.management.exception.global.CustomGlobalException;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
@Data
public class NotFoundException extends CustomGlobalException {

	private final String msg;
	
}
