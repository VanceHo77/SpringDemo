package com.spring.demo.service;

import java.util.List;

import entities.Demo;

public interface DemoRepository {
	Demo findDemo(long id);

	List<Demo> findAll();

	List<Demo> paginateQuery(int start, int size);
}
