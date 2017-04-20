package com.spring.Environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class App {

	@Value("${app.title}")
	private String title;
	@Value("${app.name}")
	private String name;
	@Value("#{T(System).currentTimeMillis()}")
	private String curTime;
	@Value("#{8+9}")
	private Integer addRs;
	@Value("#{systemProperties['app.title']}")
	private String spelTitle;
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printCurTime() {
		System.out.println("CurrentTime:" + curTime);
	}

	public Integer add() {
		return addRs;
	}
	
	public String getSpElTitle(){
		return spelTitle;
	}

	

}
