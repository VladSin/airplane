package org.example.airplane.sin.web.config;

import org.example.airplane.sin.service.config.ServiceConfig;
import org.example.airplane.sin.web.controller.HelloController;
import org.example.airplane.sin.web.controller.PersonPageController;
import org.example.airplane.sin.web.controller.PersonRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebConfig {

    private ServiceConfig serviceConfig;

    public WebConfig(ServiceConfig serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    @Bean
    public HelloController helloController(){
        return new HelloController();
    }

    @Bean
    public PersonRestController personRestController(){
        return new PersonRestController(
                serviceConfig.personService()
        );
    }

    @Bean
    public PersonPageController personPageController(){
        return new PersonPageController(
                serviceConfig.personService()
        );
    }
}
