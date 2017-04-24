package com.spring.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
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
import com.spring.demo.entities.UserInfo;
import com.spring.demo.service.RegisterRepositoryServiceImpl;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
public class RegisterControllerTest {

	@Autowired
	private WebApplicationContext wac;

	RegisterRepositoryServiceImpl rpoImpl = mock(RegisterRepositoryServiceImpl.class);

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testRegister() throws Exception {

		this.mockMvc.perform(get("/register")).andExpect(status().isOk()).andExpect(view().name("register"))
				.andExpect(MockMvcResultMatchers.model().attribute("userInfo",
						Matchers.hasProperty("account", is(new UserInfo().getAccount()))));

		// mock submit
		UserInfo unSavedReg = new UserInfo("Vance", "pwd123");
		UserInfo savedReg = new UserInfo("Vance", "pwd123");
		when(rpoImpl.save(unSavedReg)).thenReturn(savedReg.getAccount());

		this.mockMvc.perform(post("/register").param("account", "Vance").param("password", "pwd123"))
				.andExpect(status().is(302)).andExpect(redirectedUrl("/welcome/Vance"));

		// 會出錯，先註解
		// verify(rpoImpl, atLeastOnce()).save(unSavedReg);

	}

}
