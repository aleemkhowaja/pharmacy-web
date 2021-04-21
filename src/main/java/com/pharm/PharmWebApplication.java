package com.pharm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class PharmWebApplication extends SpringBootServletInitializer {

//	@Bean
//	public WebMvcConfigurer corsConfigurer()
//	{
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/*")
//						.allowedHeaders("*")
//						.allowedOrigins("*")
//						.allowedMethods("*")
//						.allowCredentials(true)
//				.allowCredentials(true);
//			}
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(PharmWebApplication.class, args);
	}



}
