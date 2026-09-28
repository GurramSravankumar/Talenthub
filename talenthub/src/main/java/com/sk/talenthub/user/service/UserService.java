package com.sk.talenthub.user.service;

import java.util.Optional;

import com.sk.talenthub.user.entity.User;

public interface UserService {

	 User getCurrentUser(String email);
	 User findByEmail(String email);
	 User findById(Long id);   
}
