package org.example.airplane.sin.dao.config;

import org.example.airplane.sin.dao.repository.BaseDao;
import org.example.airplane.sin.dao.repository.PersonDao;
import org.example.airplane.sin.dao.repository.impl.BaseDaoImpl;
import org.example.airplane.sin.dao.repository.impl.PersonDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@Configuration
@Import(HibernateConfig.class)
@EnableTransactionManagement
public class DaoConfig {

    private final EntityManagerFactory entityManagerFactory;

    public DaoConfig(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Bean
    public BaseDao baseDao(){
        return new BaseDaoImpl();
    }

    @Bean
    public PersonDao personDao(){
        return new PersonDaoImpl();
    }
}
