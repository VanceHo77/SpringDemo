package com.spring.cdplayer;

import org.springframework.stereotype.Component;

@Component
public class VideoCD {
	private String  title = "Video CD.";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
