package com.bootcamp.oauth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.oauth.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	Optional<UserEntity> findByEmailId(String emailId);

}
