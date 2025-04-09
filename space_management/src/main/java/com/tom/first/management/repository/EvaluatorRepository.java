package com.tom.first.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tom.first.management.model.Evaluator;

public interface EvaluatorRepository extends JpaRepository<Evaluator, Long> {

}
