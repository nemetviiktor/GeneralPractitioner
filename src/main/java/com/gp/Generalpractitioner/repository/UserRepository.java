package com.gp.Generalpractitioner.repository;

import org.springframework.data.repository.CrudRepository;

import com.gp.Generalpractitioner.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);
}