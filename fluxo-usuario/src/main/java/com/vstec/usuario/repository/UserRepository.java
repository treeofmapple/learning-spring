package com.vstec.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vstec.usuario.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByEmail(String email);
}
