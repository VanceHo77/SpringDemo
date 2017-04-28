package com.spring.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.demo.entities.User;

@Service
public class UserRepositoryServiceImpl implements UserRepository {

	private static List<User> TestDataSet;

	public static List<User> getTestDataSet() {
		if (TestDataSet == null) {
			TestDataSet = new ArrayList<User>();
			TestDataSet.add(new User("Vance", "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92"));
			TestDataSet.add(new User("Admin", "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92"));
			TestDataSet.add(new User("user01", "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92"));
		}
		return TestDataSet;
	}

	public UserRepositoryServiceImpl() {
		getTestDataSet();
	}

	@Override
	public User findByUsername(String username) {
		return TestDataSet.stream().filter(p -> p.getUsername().equals(username.trim())).findFirst().orElse(null);
	}

	public static void main(String... a) {
		ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
		String hashOutput = encoder.encodePassword("123456", null);
		System.out.println(hashOutput);
	}
}
