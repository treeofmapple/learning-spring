package com.pogeku.veiculo.exception;

import java.util.Map;

public record ErrorResponse(Map<String, String> errors) {
}
