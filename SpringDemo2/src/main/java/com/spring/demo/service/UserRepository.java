package com.spring.demo.service;

import com.spring.demo.entities.User;

public interface UserRepository {

	User findByUsername(String username);
}
