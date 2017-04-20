package com.spring.environment;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.Environment.App;
import com.spring.Environment.EnvConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EnvConfig.class)
public class EnvTest {
	//從App2取值放到App物件
	@Value("#{T(com.spring.Environment.App2).getAliasName()}")
	private String app2aliasName;
	@Value("#{T(com.spring.Environment.App2).getAliasName()+'，測試中文' eq 'Test App2.aliasName，測試中文'}")
	private String app2aliasName1;
	@Value("#{null?:'值為NULL則給預設值'}")
	private String app2aliasName2;

	@Autowired
	private App app;
	
	@Value("#{T(com.spring.Environment.Apps).getApps()[1].title}")
	private String appTitle;
	//查詢子集
	@Value("#{T(com.spring.Environment.Apps).getApps().?[title eq 'Apps0.title']}")
	private List<App> appsQuery;
	@Value("#{T(com.spring.Environment.Apps).getApps().?[title eq 'Apps1.title']}")
	private List<App> appsQuery1;

	@Test
	public void printAppPropertype() {
		app.printCurTime();
		assertEquals((Integer) 17, app.add());
		assertEquals("Test Title", app.getTitle());
		assertEquals("Test Name", app.getName());
//		assertEquals("Test Title", app.getSpElTitle());//測試GG
		assertEquals("Test App2.aliasName", app2aliasName);
		assertEquals("true", app2aliasName1);
		assertEquals("值為NULL則給預設值", app2aliasName2);
		assertEquals("Apps1.title", appTitle);
		//測試查詢子集
		assertEquals("Apps0.title", appsQuery.get(0).getTitle());
		assertEquals("Apps1.title", appsQuery1.get(0).getTitle());
	}
	
}
