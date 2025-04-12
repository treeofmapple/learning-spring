package com.tom.first.establishment.exception.global;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(
		
		LocalDateTime timestamp,
		int status,
		String error,
		String message,
		String path,
		Map<String, String> errors
) {
}
