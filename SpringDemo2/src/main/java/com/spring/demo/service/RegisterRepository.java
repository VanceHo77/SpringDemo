package com.spring.demo.service;

import com.spring.demo.entities.UserInfo;

public interface RegisterRepository {
	public String save(UserInfo form);
}
