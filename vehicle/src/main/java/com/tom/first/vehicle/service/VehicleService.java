package com.tom.first.vehicle.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tom.first.vehicle.common.EntityUpdater;
import com.tom.first.vehicle.config.ServiceLogger;
import com.tom.first.vehicle.exception.AlreadyExistsException;
import com.tom.first.vehicle.exception.NotFoundException;
import com.tom.first.vehicle.mapper.VehicleMapper;
import com.tom.first.vehicle.model.Vehicle;
import com.tom.first.vehicle.repository.VehicleRepository;
import com.tom.first.vehicle.request.VehicleRequest;
import com.tom.first.vehicle.request.VehicleResponse;
import com.tom.first.vehicle.request.VehicleUpdate;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleService {

	private final VehicleRepository repository;
	private final VehicleMapper mapper;
	private final EntityUpdater system;

	public List<VehicleResponse> findAll() {
		ServiceLogger.info("Requesting all vehicle data");
		List<Vehicle> vehicles = repository.findAll();
		if (vehicles.isEmpty()) {
			ServiceLogger.warn("No vehicles found in the database.");
			throw new NotFoundException("No vehicles were found.");
		}
		ServiceLogger.info("Found " + vehicles.size() + " vehicles");
		return vehicles.stream().map(mapper::fromVehicle).collect(Collectors.toList());
	}

	public VehicleResponse findByPlate(String plate) {
		ServiceLogger.info("Searching for vehicle with plate: '" + plate + "'");
		return repository.findByPlate(plate)
				.map(mapper::fromVehicle)
				.orElseThrow(() -> {
					ServiceLogger.warn("Vehicle with plate '" + plate + "' not found");
					return new NotFoundException(String.format("Vehicle with plate '%s' was not found.", plate));
				});
	}

	@Transactional
	public VehicleResponse createVehicle(VehicleRequest request) {
		ServiceLogger.info("Creating new vehicle with plate: '" + request.licensePlate() + "'");

		if (repository.existsByPlate(request.licensePlate())) {
			ServiceLogger.warn("Attempted to create vehicle that already exists with plate: '" + request.licensePlate() + "'");
			throw new AlreadyExistsException(String.format("A vehicle with plate '%s' already exists.", request.licensePlate()));
		}

		var vehicle = mapper.toVehicle(request);
		repository.save(vehicle);
		ServiceLogger.info("Successfully created vehicle with plate: '" + vehicle.getPlate() + "'");
		return mapper.fromVehicle(vehicle);
	}

	@Transactional
	public VehicleResponse updateVehicle(String plate, VehicleUpdate request) {
		ServiceLogger.info("Updating vehicle with plate: '" + plate + "'");

		var vehicle = repository.findByPlate(plate)
				.orElseThrow(() -> {
					ServiceLogger.warn("Failed to update - vehicle with plate '" + plate + "' not found");
					return new NotFoundException(String.format("Vehicle with plate '%s' was not found.", plate));
				});

		system.mergeVehicle(vehicle, request);
		repository.save(vehicle);
		ServiceLogger.info("Successfully updated vehicle with plate: '" + plate + "'");
		return mapper.fromVehicle(vehicle);
	}

	@Transactional
	public void deleteVehicle(String plate) {
		ServiceLogger.info("Attempting to delete vehicle with plate: '" + plate + "'");

		if (!repository.existsByPlate(plate)) {
			ServiceLogger.warn("Deletion failed - vehicle with plate '" + plate + "' does not exist");
			throw new NotFoundException(String.format("Vehicle with plate '%s' does not exist.", plate));
		}

		repository.deleteByPlate(plate);
		ServiceLogger.info("Successfully deleted vehicle with plate: '" + plate + "'");
	}
}
