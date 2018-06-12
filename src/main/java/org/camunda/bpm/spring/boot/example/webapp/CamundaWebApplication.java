package org.camunda.bpm.spring.boot.example.webapp;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableProcessApplication
public class CamundaWebApplication {

  public static void main(String... args) {
    SpringApplication.run(CamundaWebApplication.class, args);
  }

  @Bean
  public CorsFilter corsFilter() {

      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
      // config.setAllowCredentials(true); 
      config.addAllowedOrigin("http://localhost:8080");
      config.addAllowedHeader("*");
      config.addAllowedMethod("GET");
      config.addAllowedMethod("POST");
      config.addAllowedMethod("PUT");
      source.registerCorsConfiguration("/**", config);
      return new CorsFilter(source);
  }
}
