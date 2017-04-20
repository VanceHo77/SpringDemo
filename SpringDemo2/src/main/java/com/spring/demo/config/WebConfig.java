package com.spring.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.demo.*")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * ���ϸѪR��
	 *
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver() {
		// ��ڤƵ��ϸѪR���A�㦳UrlBasedViewResolver�S�ʡ]����ϦW�ഫURL�^�A�����InternalResourceView�AJstlView
		// �MTilesView�����ϡC
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		// �]�m�o�ӵ��ϸѪR���Ыص��Ϫ�class
		viewResolver.setViewClass(InternalResourceView.class);
		// �e��
		viewResolver.setPrefix("/WEB-INF/views/");
		// ���
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean(name = "messageSource")
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
		bean.setBasename("/WEB-INF/ValidationMessages");
		bean.setDefaultEncoding("UTF-8");
		return bean;
	}

}
