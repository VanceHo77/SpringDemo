package com.spring.demo.config;

import java.io.File;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.spring.demo.utils.FileUtil;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	private static final long MAX_FILE_SIZE = 52428800; // 50MB : Max file size.

	// Beyond that size spring will throw exception.
	// 20MB : Total request size containing Multi part.
	private static final long MAX_REQUEST_SIZE = 20971520;

	// Size threshold after which files will be written to disk
	private static final int FILE_SIZE_THRESHOLD = 0;

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new CharacterEncodingFilter("UTF-8"),
				new DelegatingFilterProxy("springSecurityFilterChain") };
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
		registration.setMultipartConfig(getMultipartConfigElement());
	}

	private MultipartConfigElement getMultipartConfigElement() {
		String location = "";
		File f = new File(FileUtil.createFileResourcePath(this));
		if (!f.exists()) {
			f.mkdirs();
		}
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(location, MAX_FILE_SIZE,
				MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
		return multipartConfigElement;
	}

}
