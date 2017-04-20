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
	 * 視圖解析器
	 *
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver() {
		// 國際化視圖解析器，具有UrlBasedViewResolver特性（把視圖名轉換URL），它支持InternalResourceView，JstlView
		// 和TilesView等視圖。
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		// 設置這個視圖解析器創建視圖的class
		viewResolver.setViewClass(InternalResourceView.class);
		// 前綴
		viewResolver.setPrefix("/WEB-INF/views/");
		// 後綴
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
