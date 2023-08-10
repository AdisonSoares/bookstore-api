package com.adison.bookstore.config;

import com.adison.bookstore.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Autowired
    private DBService dbService;
    @Bean
    public void instanciaBaseDeDados(){
        this.dbService.instaciaBaseDeDados();
    }
}
