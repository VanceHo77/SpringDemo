package com.spring.qualifier;

import org.springframework.stereotype.Component;

@Component
public class Student2 extends Student {

	public final Integer age;
	public final String name;

	public Student2() {
		super();
		this.age = 18;
		this.name = "EFG";
	}
}
