package com.tom.first.management.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;

import com.tom.first.management.model.Equipament;
import com.tom.first.management.model.PhysicalSpace;
import com.tom.first.management.model.User;
import com.tom.first.management.model.enums.Status;

public record SolicitationResponse(
		
		String NameSpace, 
		String TypeSpace, 
		Set<String> Equipaments,
		String User, 
		String Solicitacao, 
		LocalDate DateStart, 
		LocalDate DateEnd, 
		LocalTime HourStart,
		LocalTime HourEnd, 
		LocalDate DateSolicitation, 
		LocalDate DateStatus,
		Status Status, 
		String Justification
		
) {
	public SolicitationResponse(PhysicalSpace Space, User User, String Solicitation, LocalDate DateStart,
			LocalDate DateEnd, LocalTime HourStart, LocalTime HourEnd, LocalDate DateSolicitation, LocalDate DateStatus,
			Status Status, String Justification) {
		this(Space.getName(), Space.getType(), Space.getEquipaments().stream().map(Equipament::getName).collect(Collectors.toSet()), User.getName().toString(),
				Solicitation, DateStart, DateEnd, HourStart, HourEnd, DateSolicitation, DateStatus, Status, Justification
				);
	}
	
}
