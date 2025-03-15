package com.tom.first.username.exception;

import java.util.Map;

public record ErrorResponse(Map<String, String> errors) {

}
