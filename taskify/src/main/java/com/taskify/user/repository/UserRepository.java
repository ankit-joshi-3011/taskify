package com.taskify.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.taskify.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
