package com.spring.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.demo.entities.UserInfo;
import com.spring.demo.service.DemoRepositoryServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping({ "/", "/homepage" })
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private DemoRepositoryServiceImpl repoImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("demo", repoImpl.findDemo(6));
		model.addAttribute("demos", repoImpl.findAll());

		return "home";
	}

	@RequestMapping(value = "/null", method = RequestMethod.GET)
	public String nullTest(Locale locale, Model model) throws NullPointerException {
		UserInfo user = null;
		user.getAccount();
		return "home";
	}

}
