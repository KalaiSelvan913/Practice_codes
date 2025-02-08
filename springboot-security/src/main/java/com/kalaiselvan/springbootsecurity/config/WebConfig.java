package com.kalaiselvan.springbootsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Apply CORS to all paths
                .allowedOrigins("http://localhost:4209")  // Allow only Angular app
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allowed HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // If you're using credentials like cookies
    }
	
//
//    @Bean
//    WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//				.allowedOrigins("http://localhost:4200")
//				.allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
//				.allowedHeaders("*")
//				.allowCredentials(true);
//			}
//		};
//	}

}
