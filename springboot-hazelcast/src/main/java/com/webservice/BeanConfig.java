package com.webservice;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.webservice.dataaccess.DataAccess;
import com.webservice.dataaccess.HazelCastDataAccessImpl;
import com.webservice.dataaccess.HazelCastDataLoader;

@Configuration
@EnableJpaRepositories
public class BeanConfig {
    @SuppressWarnings("unused")
    private static final String RESOURCE_ID = "rest-service";    
   @Bean
    DataAccess dataAccessLayer() {
        return new HazelCastDataAccessImpl();
    }
    
  
    
    @Bean
    HazelCastDataLoader dataLoader() {
        return new HazelCastDataLoader();
    }
    
    
    @PostConstruct
    public void postConstructInitCache() {
        dataLoader().loadCache();
    }
}
