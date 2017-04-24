package com.spring.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
import com.spring.demo.entities.Demo;
import com.spring.demo.service.DemoRepositoryServiceImpl;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
public class HomeControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Autowired
	DemoRepositoryServiceImpl rpoImpl = mock(DemoRepositoryServiceImpl.class);

	Demo demo;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		demo = rpoImpl.findDemo(6);
	}

	@Test
	public void testHomePage() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("home"));
		this.mockMvc.perform(get("/homepage")).andExpect(status().isOk()).andExpect(view().name("home"));
		this.mockMvc.perform(get("/")).andExpect(view().name("home")).andExpect(
				MockMvcResultMatchers.model().attribute("demo", Matchers.hasProperty("id", is(demo.getId()))));
		this.mockMvc.perform(get("/")).andExpect(view().name("home"))
				.andExpect(MockMvcResultMatchers.model().attribute("demos", Matchers.hasSize(9)));
	}
}
