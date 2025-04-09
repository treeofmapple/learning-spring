package com.tom.first.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tom.first.management.model.Equipament;

public interface EquipamentRepository extends JpaRepository<Equipament, Long> {

}
