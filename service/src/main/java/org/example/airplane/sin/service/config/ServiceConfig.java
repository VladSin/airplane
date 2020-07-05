package org.example.airplane.sin.service.config;

import org.example.airplane.sin.dao.config.DaoConfig;
import org.example.airplane.sin.dao.repository.PersonDao;
import org.example.airplane.sin.service.repository.BaseService;
import org.example.airplane.sin.service.repository.PersonService;
import org.example.airplane.sin.service.repository.impl.BaseServiceImpl;
import org.example.airplane.sin.service.repository.impl.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    private DaoConfig daoConfig;

    public ServiceConfig(DaoConfig daoConfig) {
        this.daoConfig = daoConfig;
    }

    @Bean
    public BaseService baseService(){
        return new BaseServiceImpl(daoConfig.baseDao());
    }

    @Bean
    public PersonService personDao(){
        return new PersonServiceImpl(daoConfig.personDao());
    }
}
