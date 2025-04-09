package com.tom.first.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tom.first.management.model.Audit;

public interface AuditRepository extends JpaRepository<Audit, Long> {

}
