package com.spring.cdplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements CD {

	@Autowired
	private MusicCD mCD;

	@Autowired
	private VideoCD vCD;

	@Override
	public String play() {
		return "CD1: " + mCD.getTitle() + "CD2: " + vCD.getTitle();
	}

}
