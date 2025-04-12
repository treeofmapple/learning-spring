package com.tom.first.management.mapper;

import org.springframework.stereotype.Service;

import com.tom.first.management.dto.SpaceRequest;
import com.tom.first.management.dto.SpaceRequest.SpaceRequestDTO;
import com.tom.first.management.model.PhysicalSpace;
import com.tom.first.management.repository.EquipamentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpaceMapper {

	private final EquipamentRepository repository;
	
	public PhysicalSpace toSpace(SpaceRequest request) {
		
		
		
	}
	
	public PhysicalSpace toSpaceDTO(SpaceRequestDTO request) {
		
		
		
	}
	
	public PhysicalSpace fromSpace(PhysicalSpace space) {
		
		
		
	}
	
	
	
	
	
}
