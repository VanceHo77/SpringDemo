package com.spring.demo.controller;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.spring.demo.config.WebConfig;
import com.spring.demo.service.DemoRepositoryServiceImpl;

import entities.Demo;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
public class ShowDemoControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	DemoRepositoryServiceImpl rpoImpl = mock(DemoRepositoryServiceImpl.class);

	List<Demo> demos;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		demos = rpoImpl.findAll();
	}

	@Test
	public void testShowDemo() throws Exception {
		// 代刚modelい琌ΤList<Demo>
		this.mockMvc.perform(get("/")).andExpect(view().name("home"))
				.andExpect(MockMvcResultMatchers.model().attribute("demos", Matchers.hasSize(9)));
		// 代刚Get琩高把计ㄏノ琩高把计獶戈方
		this.mockMvc.perform(get("/show?start=0&size=3")).andExpect(view().name("showDemo"))
				.andExpect(MockMvcResultMatchers.model().attribute("demos", Matchers.hasSize(3)));
		// 代刚Get琩高把计ㄏノ隔畖把计戈方
		this.mockMvc.perform(get("/show/0/3")).andExpect(view().name("showDemo"))
				.andExpect(MockMvcResultMatchers.model().attribute("demos", Matchers.hasSize(3)));
	}
}
