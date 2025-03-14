package com.taskify.user.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.taskify.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	Optional<User> findByUsername(String username);
}
