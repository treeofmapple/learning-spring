package com.tom.first.management.exception.global;

@SuppressWarnings("serial")
public abstract class DateGlobalException extends NumberFormatException {
	public abstract String getMsg();
}
