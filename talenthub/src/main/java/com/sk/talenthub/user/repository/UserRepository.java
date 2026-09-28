package com.sk.talenthub.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.talenthub.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);

}
