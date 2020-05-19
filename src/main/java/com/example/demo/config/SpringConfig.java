package com.example.demo.config;

import com.example.demo.model.MoviesDAO;
import com.example.demo.model.MoviesDAOImpl;
import com.example.demo.service.MovieService;
import com.example.demo.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration

public class SpringConfig {


    @Bean

    @Qualifier("NumberDAO")
    public MoviesDAO getNumberDAO() {
        return new MoviesDAOImpl();
    }

    @Bean
    @Qualifier("NumberService")
    public MovieService getNumberService() {
        return new MovieServiceImpl();
    }
}
