package com.spring.demo.controller;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.demo.entities.UserInfo;
import com.spring.demo.service.RegisterRepository;
import com.spring.demo.utils.FileUtil;
import com.spring.demo.validation.UserInfoValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping({ "/register" })
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	RegisterRepository rpo;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new UserInfoValidator());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String register(Model model) {
		logger.info("Register page.");
		model.addAttribute("userInfo", new UserInfo());
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerSubmit(@Valid UserInfo form, BindingResult errors, Model model) {

		if (errors.hasErrors()) {
			return "register";
		}
		if ("1".equals(rpo.save(form))) {
			model.addAttribute("user", form);
		} else {
			model.addAttribute("user", null);
		}

		if (null != form.getUserImg()) {
			try {
				String fileUrl = FileUtil.createFileResourcePath(this);
				form.getUserImg().transferTo(new File(fileUrl + form.getUserImg().getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				logger.error(e.getMessage());
			}
		}

		return "redirect:/welcome/" + form.getAccount();
	}

}
