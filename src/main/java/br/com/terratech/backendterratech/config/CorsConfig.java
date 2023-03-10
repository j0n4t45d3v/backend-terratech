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
    registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("Authorization", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers")
            .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
            .allowCredentials(false);

    /* registry.addMapping("/**")
            .allowedOrigins("https://terratech.vercel.app")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("Authorization", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers")
            .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
            .allowCredentials(false);

    registry.addMapping("/**")
            .allowedOrigins("http://127.0.0.1:5500/")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("Authorization", "Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers")
            .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
            .allowCredentials(false);*/
  }
}
