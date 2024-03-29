package com.pawan.spring.webrestful;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class WebRestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebRestfulApplication.class, args);
	}

	@Bean
	public LocaleResolver localeresolver() {
		AcceptHeaderLocaleResolver localResolver = new AcceptHeaderLocaleResolver();
		localResolver.setDefaultLocale(Locale.US);
		return localResolver;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("messages");
		return resourceBundleMessageSource;
	}
}
