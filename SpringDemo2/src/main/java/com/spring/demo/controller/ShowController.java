package com.spring.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.demo.service.DemoRepositoryServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping({ "/show" })
public class ShowController {

	private static final Logger logger = LoggerFactory.getLogger(ShowController.class);

	@Autowired
	private DemoRepositoryServiceImpl repoImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String showDemoByRequestParam(@RequestParam(defaultValue = "0") int start,
			@RequestParam(defaultValue = "3") int size, Model model) {
		logger.info("Show Demo, by not faced resource.");

		model.addAttribute("demos", repoImpl.paginateQuery(start, size));

		return "showDemo";
	}

	@RequestMapping(value = "/{start}/{size}", method = RequestMethod.GET)
	public String showDemoByPathVariable(@PathVariable int start, @PathVariable int size, Model model) {
		logger.info("Show Demo, by faced resource.");

		model.addAttribute("demos", repoImpl.paginateQuery(start, size));

		return "showDemo";
	}
}
