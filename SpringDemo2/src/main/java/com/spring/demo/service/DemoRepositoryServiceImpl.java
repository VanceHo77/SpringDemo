package com.spring.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.demo.entities.Demo;

@Service
public class DemoRepositoryServiceImpl implements DemoRepository {

	private static List<Demo> TestDataSet;

	public static List<Demo> getTestDataSet() {
		if (TestDataSet == null) {
			TestDataSet = new ArrayList<Demo>();
			TestDataSet.add(new Demo(1l, "Test Data1", 123.1, 10.1));
			TestDataSet.add(new Demo(2l, "Test Data2", 123.2, 10.2));
			TestDataSet.add(new Demo(3l, "Test Data3", 123.3, 10.3));
			TestDataSet.add(new Demo(4l, "Test Data4", 123.4, 10.4));
			TestDataSet.add(new Demo(5l, "Test Data5", 123.5, 10.5));
			TestDataSet.add(new Demo(6l, "Test Data6", 123.6, 10.6));
			TestDataSet.add(new Demo(7l, "Test Data7", 123.7, 10.7));
			TestDataSet.add(new Demo(8l, "Test Data8", 123.8, 10.8));
			TestDataSet.add(new Demo(9l, "Test Data9", 123.9, 10.9));
		}
		return TestDataSet;
	}

	public DemoRepositoryServiceImpl() {
		getTestDataSet();
	}

	@Override
	public Demo findDemo(long id) {
		Demo demo = TestDataSet.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
		return demo;
	}

	@Override
	public List<Demo> findAll() {
		return TestDataSet;
	}

	@Override
	public List<Demo> paginateQuery(int start, int size) {
		List<Demo> demos = TestDataSet.stream().skip(start * size).limit(size).collect(Collectors.toList());

		return demos;
	}

}
