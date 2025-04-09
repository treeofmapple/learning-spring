package com.tom.first.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tom.first.management.model.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {

}
