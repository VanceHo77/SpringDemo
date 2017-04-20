package com.spring.demo.service;

import org.springframework.stereotype.Service;

import entities.UserInfo;

@Service
@SuppressWarnings("static-access")
public class RegisterRepositoryServiceImpl implements RegisterRepository {

	private static UserInfo UserInfo;

	@Override
	public String save(UserInfo userInfo) {
		this.UserInfo = userInfo;
		return this.UserInfo == null ? "0" : "1";
	}

}
