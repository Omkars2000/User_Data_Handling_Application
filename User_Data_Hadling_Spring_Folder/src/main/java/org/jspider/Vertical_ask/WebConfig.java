package org.jspider.Vertical_ask;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000") // Allow requests from the React app
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // Allow all HTTP methods

    }
}
