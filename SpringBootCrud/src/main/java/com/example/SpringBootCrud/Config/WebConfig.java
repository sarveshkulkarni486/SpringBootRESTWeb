package com.example.SpringBootCrud.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	public void addCorsMapping(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("http://localhost:5173/")
		.allowedMethods("PUT", "POST", "GET", "DELETE", "OPTIONS")
		.allowedHeaders("*")
		.allowCredentials(true);
		
		
	}

}
