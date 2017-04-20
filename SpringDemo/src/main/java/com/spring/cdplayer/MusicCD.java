package com.spring.cdplayer;

import org.springframework.stereotype.Component;

@Component
public class MusicCD {
	private String  title = "Music CD.";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
