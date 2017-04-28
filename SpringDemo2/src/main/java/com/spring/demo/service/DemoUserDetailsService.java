package com.spring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.demo.entities.User;

@Service
public class DemoUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository upo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = upo.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("找不到該帳號");
		}
		return user;
	}

}
