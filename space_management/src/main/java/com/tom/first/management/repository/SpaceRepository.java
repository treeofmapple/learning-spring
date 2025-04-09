package com.tom.first.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tom.first.management.model.PhysicalSpace;

public interface SpaceRepository extends JpaRepository<PhysicalSpace, Long> {

}
