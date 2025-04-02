package com.pogeku.veiculo.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Tipo {
	CARRO, MOTO ;
	
    @JsonCreator
    public static Tipo fromString(String value) {
        return Tipo.valueOf(value.toUpperCase());
    }
}
