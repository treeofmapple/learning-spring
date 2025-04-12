package com.tom.first.management.exception;

import com.tom.first.management.exception.global.DateGlobalException;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
@Data
public class InvalidDateException extends DateGlobalException {
	private final String msg;
}
