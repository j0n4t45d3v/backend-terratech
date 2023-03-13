package br.com.terratech.backendterratech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
//    registry.addMapping("/**")
//            .allowedOrigins("*")
//            .allowedMethods("GET", "POST", "PUT", "DELETE")
//            .allowedHeaders("Authorization", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers")
//            .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
//            .allowCredentials(false);
    // Allowed Origins *
    registry.addMapping("/**")
//            .allowedOrigins("https://terratech.vercel.app", "https://terratech.netlify.app/")
//            .allowedMethods("GET", "POST", "PUT", "DELETE")
//            .allowedHeaders("Access-Control-Allow-Origin", "Authorization", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Allow-Method", "Access-Control-Allow-Headers")
//            .allowCredentials(false);
              .allowedOrigins("*")
              .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
              .allowCredentials(true)
              .maxAge(3600);
  }
}