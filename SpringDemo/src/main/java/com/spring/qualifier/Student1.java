package com.spring.qualifier;

import org.springframework.stereotype.Component;

@Component
public class Student1 extends Student {

	public final Integer age;
	public final String name;

	public Student1() {
		super();
		this.age = 3;
		this.name = "ABC";
	}
}
