package com.spring.demo.service;

import entities.UserInfo;

public interface RegisterRepository {
	public String save(UserInfo form);
}
