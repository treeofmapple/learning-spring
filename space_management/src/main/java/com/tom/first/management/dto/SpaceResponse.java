package com.tom.first.management.dto;

import java.util.Set;
import java.util.stream.Collectors;

import com.tom.first.management.model.Equipament;
import com.tom.first.management.model.enums.Availability;

public record SpaceResponse(
		
		String Name,
		String Type,
		double Size,
		Availability availability,
		EquipamentName Equipaments
		
) {
	
	public SpaceResponse(String Name, String Type, double Size, Availability availability, Set<Equipament> equipaments) {
	    this(Name, Type, Size, availability, EquipamentName.from(equipaments));
	}
	
	public record EquipamentName(Set<String> Name) {
		public static EquipamentName from(Set<Equipament> equipaments) {
			Set<String> names = equipaments.stream().map(Equipament::getName).collect(Collectors.toSet());
			return new EquipamentName(names);
		}
	}
	
}
