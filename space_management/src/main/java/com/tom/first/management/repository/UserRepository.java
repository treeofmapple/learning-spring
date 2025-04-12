package com.tom.first.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tom.first.management.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByEmail(String email);
}
