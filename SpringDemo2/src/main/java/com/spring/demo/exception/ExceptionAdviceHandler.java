package com.spring.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

@ControllerAdvice
public class ExceptionAdviceHandler extends DefaultHandlerExceptionResolver {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionAdviceHandler.class);

	private static final String ERROR_PAGE = "/error";

	@ExceptionHandler(value = Exception.class)
	public ModelAndView exceptionHandler(HttpServletRequest req, Exception e) {
		logger.error(e.getMessage());

		return new ModelAndView(ERROR_PAGE);
	}

}
