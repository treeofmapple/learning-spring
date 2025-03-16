package com.tom.first.management.exception;

import java.util.Map;

public record ErrorResponse(Map<String, String> errors) {
}
