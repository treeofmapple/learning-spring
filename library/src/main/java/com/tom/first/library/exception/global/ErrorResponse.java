package com.tom.first.library.exception.global;

import java.util.Map;

public record ErrorResponse(Map<String, String> errors) {
}
