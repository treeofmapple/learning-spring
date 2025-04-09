package com.tom.first.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tom.first.management.model.Solicitation;

public interface SolicitationRepository extends JpaRepository<Solicitation, Long> {

}
