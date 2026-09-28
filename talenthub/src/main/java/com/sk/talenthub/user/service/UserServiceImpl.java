package com.sk.talenthub.user.service;

import org.springframework.stereotype.Service;

import com.sk.talenthub.user.entity.User;
import com.sk.talenthub.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public User getCurrentUser(String email) {
		return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found with email: " + email));
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found with email: " + email));
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	}

}
