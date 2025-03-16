package com.tom.first.simple.exception;

import java.util.Map;

public record ErrorResponse(Map<String, String> errors) {
}
