package br.everest.hop.orm.exception;

import java.util.Map;

public record ErrorResponse(Map<String, String> errors) {
}
