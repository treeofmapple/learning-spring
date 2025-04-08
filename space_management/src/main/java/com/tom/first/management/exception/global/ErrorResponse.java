package com.tom.first.management.exception.global;

import java.util.Map;

public record ErrorResponse(Map<String, String> errors) {
}
