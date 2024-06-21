package com.sigrh.gestionressourceh.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
          registry.addMapping("/**")
                  .allowedOrigins("https://localhost:4200")  // Spécifiez l'origine autorisée
                  .allowedMethods("GET", "POST", "PUT", "DELETE")  // Méthodes HTTP autorisées
                  .allowedHeaders("Content-Type")  // En-têtes autorisés
                  .allowCredentials(true)  // Autoriser les informations d'authentification
                  .maxAge(3600);  // Durée de mise en cache des résultats de la requête pré-vol

    }
}
