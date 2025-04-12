package com.tom.first.establishment.common;

import org.springframework.stereotype.Service;

import com.tom.first.establishment.dto.EstablishmentUpdate;
import com.tom.first.establishment.model.Establishment;

@Service
public class SystemOperations {

	public void mergeEstablishment(Establishment place, EstablishmentUpdate request) {
		place.setName(request.name());
		place.setCnpj(request.cnpj());
		place.setAddress(request.address());
		place.setTelephone(request.phone());
		place.setVacanciesMotorcycles(request.motorcycleSpotCount());
		place.setVacanciesCars(request.carSpotCount());
	}

}
