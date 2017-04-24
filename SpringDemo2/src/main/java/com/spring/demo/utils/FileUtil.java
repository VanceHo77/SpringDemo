package com.spring.demo.utils;

public class FileUtil {

	public static String createFileResourcePath(Object clazz) {
		// if exists /resources/temp/
		String[] pathAry = clazz.getClass().getResource("/").toString().split("/");
		String location = "";
		for (int i = 1; i < 6; i++) {
			location += pathAry[i] + "/";
		}
		return location += "resources/temp/";
	}
}
