package com.spring.Environment;

import org.springframework.stereotype.Component;

@Component
public class App2 {

	private static String aliasName = "Test App2.aliasName";

	public static String getAliasName() {
		return aliasName;
	}

	
}
