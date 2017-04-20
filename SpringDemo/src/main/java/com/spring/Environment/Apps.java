package com.spring.Environment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Apps {

	public static List<App> getApps() {
		List<App> apps = new ArrayList<App>();
		App app = new App();
		app.setTitle("Apps0.title");
		app.setName("Apps0.name");
		apps.add(app);
		app = new App();
		app.setTitle("Apps1.title");
		app.setName("Apps1.name");
		apps.add(app);
		return apps;
	}
}
